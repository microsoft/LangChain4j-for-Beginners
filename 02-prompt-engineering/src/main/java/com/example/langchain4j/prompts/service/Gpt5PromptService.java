package com.example.langchain4j.prompts.service;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.request.ChatRequest;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.chat.response.StreamingChatResponseHandler;
import dev.langchain4j.model.openaiofficial.OpenAiOfficialChatModel;
import dev.langchain4j.model.openaiofficial.OpenAiOfficialStreamingChatModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Gpt5PromptService - GPT-5.2 Prompting Best Practices
 * Run: ./start.sh (from module directory, after deploying Azure resources with azd up)
 * 
 * Service demonstrating GPT-5.2 prompting best practices with LangChain4j.
 * 
 * Based on OpenAI's GPT-5 Prompting Guide:
 * https://github.com/openai/openai-cookbook/blob/main/examples/gpt-5/gpt-5_prompting_guide.ipynb
 * 
 * Key Concepts:
 * - Low vs high eagerness (reasoning depth control)
 * - Task execution with progress updates
 * - Self-reflecting code generation with quality rubrics
 * - Structured analysis frameworks
 * - Multi-turn conversations with context
 * - Constrained output generation
 * - Explicit step-by-step reasoning
 * 
 * 💡 Ask GitHub Copilot:
 * - "What's the difference between low eagerness and high eagerness prompting patterns?"
 * - "How do the XML tags in prompts help structure the AI's response?"
 * - "When should I use self-reflection patterns vs direct instruction?"
 * - "How can I adapt these patterns for non-GPT-5 models like GPT-4?"
 */
@Service
public class Gpt5PromptService {

    private static final Logger log = LoggerFactory.getLogger(Gpt5PromptService.class);

    @Autowired
    private OpenAiOfficialChatModel chatModel;

    @Autowired
    private OpenAiOfficialStreamingChatModel streamingChatModel;

    private final Map<String, ChatMemory> sessionMemories = new ConcurrentHashMap<>();

    // ==================== STREAMING HELPER ====================

    /**
     * Private helper: streams a prompt response via SSE.
     * Used by all streaming pattern methods (except chat which needs memory).
     */
    private SseEmitter streamResponse(String prompt) {
        SseEmitter emitter = new SseEmitter(600_000L);

        // Send an initial comment to flush headers and prevent Chrome from buffering
        try {
            emitter.send(SseEmitter.event().comment("stream-start"));
        } catch (Exception e) {
            // ignore
        }

        log.info("[STREAM] Starting streaming request");
        log.debug("[STREAM] Prompt length: {} chars", prompt.length());

        streamingChatModel.chat(prompt, new StreamingChatResponseHandler() {
            private final StringBuilder fullResponse = new StringBuilder();
            private int tokenCount = 0;

            @Override
            public void onPartialResponse(String token) {
                tokenCount++;
                fullResponse.append(token);
                if (tokenCount % 50 == 0) {
                    log.info("[STREAM] Received {} tokens so far...", tokenCount);
                }
                try {
                    emitter.send(SseEmitter.event()
                            .name("token")
                            .data(token));
                } catch (Exception e) {
                    log.warn("[STREAM] Client disconnected after {} tokens", tokenCount);
                    emitter.completeWithError(e);
                }
            }

            @Override
            public void onCompleteResponse(ChatResponse response) {
                log.info("[STREAM] Completed. Total tokens: {}. Response length: {} chars",
                        tokenCount, fullResponse.length());
                try {
                    emitter.send(SseEmitter.event().name("done").data("[DONE]"));
                    emitter.complete();
                } catch (Exception e) {
                    log.warn("[STREAM] Error sending completion event", e);
                }
            }

            @Override
            public void onError(Throwable error) {
                log.error("[STREAM] Error during streaming after {} tokens: {}",
                        tokenCount, error.getMessage(), error);
                try {
                    emitter.send(SseEmitter.event()
                            .name("error")
                            .data(error.getMessage()));
                } catch (Exception e) {
                    // ignore
                }
                emitter.completeWithError(error);
            }
        });

        return emitter;
    }

    // ==================== EXAMPLE 1: LOW EAGERNESS ====================

    /**
     * Example 1: Low Eagerness - Quick, focused responses
     * Use when you want fast, direct answers without deep exploration.
     */
    public String solveFocused(String problem) {
        String prompt = """
            <context_gathering>
            - Search depth: very low
            - Bias strongly towards providing a correct answer as quickly as possible
            - Usually, this means an absolute maximum of 2 reasoning steps
            - If you think you need more time, state what you know and what's uncertain
            </context_gathering>
            
            Problem: %s
            
            Provide your answer:
            """.formatted(problem);

        return chatModel.chat(prompt);
    }

    /**
     * Example 1b: Low Eagerness with Streaming
     */
    public SseEmitter solveFocusedStreaming(String problem) {
        String prompt = """
            <context_gathering>
            - Search depth: very low
            - Bias strongly towards providing a correct answer as quickly as possible
            - Usually, this means an absolute maximum of 2 reasoning steps
            - If you think you need more time, state what you know and what's uncertain
            </context_gathering>
            
            Problem: %s
            
            Provide your answer:
            """.formatted(problem);
        return streamResponse(prompt);
    }

    // ==================== EXAMPLE 2: HIGH EAGERNESS ====================

    /**
     * Example 2: High Eagerness - Thorough, autonomous problem solving
     * Use for complex tasks where you want the model to explore thoroughly.
     */
    public String solveAutonomous(String problem) {
        String prompt = """
            Analyze this problem thoroughly and provide a comprehensive solution.
            Consider multiple approaches, trade-offs, and important details.
            Show your analysis and reasoning in your response.
            
            Problem: %s
            """.formatted(problem);

        return chatModel.chat(prompt);
    }

    /**
     * Example 2b: High Eagerness with Streaming
     * Streams tokens as they arrive so you can see progress in real-time.
     * Avoids timeout issues with long-running reasoning.
     */
    public SseEmitter solveAutonomousStreaming(String problem) {
        // 10 minute timeout for the SSE connection
        SseEmitter emitter = new SseEmitter(600_000L);

        String prompt = """
            Analyze this problem thoroughly and provide a comprehensive solution.
            Consider multiple approaches, trade-offs, and important details.
            Show your analysis and reasoning in your response.
            
            Problem: %s
            """.formatted(problem);

        log.info("[STREAM] Starting streaming request for high-eagerness prompt");
        log.debug("[STREAM] Prompt: {}", prompt);

        streamingChatModel.chat(prompt, new StreamingChatResponseHandler() {
            private final StringBuilder fullResponse = new StringBuilder();
            private int tokenCount = 0;

            @Override
            public void onPartialResponse(String token) {
                tokenCount++;
                fullResponse.append(token);
                if (tokenCount % 50 == 0) {
                    log.info("[STREAM] Received {} tokens so far...", tokenCount);
                }
                try {
                    emitter.send(SseEmitter.event()
                            .name("token")
                            .data(token));
                } catch (Exception e) {
                    log.warn("[STREAM] Client disconnected after {} tokens", tokenCount);
                    emitter.completeWithError(e);
                }
            }

            @Override
            public void onCompleteResponse(ChatResponse response) {
                log.info("[STREAM] Completed. Total tokens: {}. Response length: {} chars",
                        tokenCount, fullResponse.length());
                try {
                    emitter.send(SseEmitter.event().name("done").data("[DONE]"));
                    emitter.complete();
                } catch (Exception e) {
                    log.warn("[STREAM] Error sending completion event", e);
                }
            }

            @Override
            public void onError(Throwable error) {
                log.error("[STREAM] Error during streaming after {} tokens: {}",
                        tokenCount, error.getMessage(), error);
                try {
                    emitter.send(SseEmitter.event()
                            .name("error")
                            .data(error.getMessage()));
                } catch (Exception e) {
                    // ignore
                }
                emitter.completeWithError(error);
            }
        });

        return emitter;
    }

    // ==================== EXAMPLE 3: TASK EXECUTION ====================

    /**
     * Example 3: Task Execution with Progress Updates
     * Provides clear preambles and progress updates for better UX.
     */
    public String executeWithPreamble(String task) {
        String prompt = """
            <task_execution>
            1. First, briefly restate the user's goal in a friendly way
            
            2. Create a step-by-step plan:
               - List all steps needed
               - Identify potential challenges
               - Outline success criteria
            
            3. Execute each step:
               - Narrate what you're doing
               - Show progress clearly
               - Handle any issues that arise
            
            4. Summarize:
               - What was completed
               - Any important notes
               - Next steps if applicable
            </task_execution>
            
            <tool_preambles>
            - Always begin by rephrasing the user's goal clearly
            - Outline your plan before executing
            - Narrate each step as you go
            - Finish with a distinct summary
            </tool_preambles>
            
            Task: %s
            
            Begin execution:
            """.formatted(task);

        return chatModel.chat(prompt);
    }

    /**
     * Example 3b: Task Execution with Streaming
     */
    public SseEmitter executeWithPreambleStreaming(String task) {
        String prompt = """
            <task_execution>
            1. First, briefly restate the user's goal in a friendly way
            
            2. Create a step-by-step plan:
               - List all steps needed
               - Identify potential challenges
               - Outline success criteria
            
            3. Execute each step:
               - Narrate what you're doing
               - Show progress clearly
               - Handle any issues that arise
            
            4. Summarize:
               - What was completed
               - Any important notes
               - Next steps if applicable
            </task_execution>
            
            <tool_preambles>
            - Always begin by rephrasing the user's goal clearly
            - Outline your plan before executing
            - Narrate each step as you go
            - Finish with a distinct summary
            </tool_preambles>
            
            Task: %s
            
            Begin execution:
            """.formatted(task);
        return streamResponse(prompt);
    }

    // ==================== EXAMPLE 4: CODE GENERATION ====================

    /**
     * Example 4: Self-Reflecting Code Generation
     * Generates high-quality code using internal quality rubrics.
     */
    public String generateCodeWithReflection(String requirement) {
        String prompt = """
            Generate Java code with production-quality standards: %s
            Keep it simple and include basic error handling.
            """.formatted(requirement);

        return chatModel.chat(prompt);
    }

    /**
     * Example 4b: Code Generation with Streaming
     */
    public SseEmitter generateCodeWithReflectionStreaming(String requirement) {
        String prompt = """
            Generate Java code with production-quality standards: %s
            Keep it simple and include basic error handling.
            """.formatted(requirement);
        return streamResponse(prompt);
    }

    // ==================== EXAMPLE 5: CODE ANALYSIS ====================

    /**
     * Example 5: Structured Analysis with Clear Instructions
     * Analyzes code with specific criteria and structured output.
     */
    public String analyzeCode(String code) {
        String prompt = """
            <analysis_framework>
            You are an expert code reviewer. Analyze the code for:
            
            1. Correctness
               - Does it work as intended?
               - Are there logical errors?
            
            2. Best Practices
               - Follows language conventions?
               - Appropriate design patterns?
            
            3. Performance
               - Any inefficiencies?
               - Scalability concerns?
            
            4. Security
               - Potential vulnerabilities?
               - Input validation?
            
            5. Maintainability
               - Code clarity?
               - Documentation?
            
            <output_format>
            Provide your analysis in this structure:
            - Summary: One-sentence overall assessment
            - Strengths: 2-3 positive points
            - Issues: List any problems found with severity (High/Medium/Low)
            - Recommendations: Specific improvements
            </output_format>
            </analysis_framework>
            
            Code to analyze:
            ```
            %s
            ```
            
            Provide your structured analysis:
            """.formatted(code);

        return chatModel.chat(prompt);
    }

    /**
     * Example 5b: Structured Analysis with Streaming
     */
    public SseEmitter analyzeCodeStreaming(String code) {
        String prompt = """
            <analysis_framework>
            You are an expert code reviewer. Analyze the code for:
            
            1. Correctness
               - Does it work as intended?
               - Are there logical errors?
            
            2. Best Practices
               - Follows language conventions?
               - Appropriate design patterns?
            
            3. Performance
               - Any inefficiencies?
               - Scalability concerns?
            
            4. Security
               - Potential vulnerabilities?
               - Input validation?
            
            5. Maintainability
               - Code clarity?
               - Documentation?
            
            <output_format>
            Provide your analysis in this structure:
            - Summary: One-sentence overall assessment
            - Strengths: 2-3 positive points
            - Issues: List any problems found with severity (High/Medium/Low)
            - Recommendations: Specific improvements
            </output_format>
            </analysis_framework>
            
            Code to analyze:
            ```
            %s
            ```
            
            Provide your structured analysis:
            """.formatted(code);
        return streamResponse(prompt);
    }

    // ==================== EXAMPLE 6: MULTI-TURN CONVERSATION ====================

    /**
     * Example 6: Multi-Turn Conversation with Context Preservation
     * Maintains conversation context following GPT-5 patterns.
     */
    public String continueConversation(String userMessage, String sessionId) {
        // Get or create chat memory for this session
        ChatMemory chatMemory = sessionMemories.computeIfAbsent(
            sessionId, 
            k -> MessageWindowChatMemory.withMaxMessages(10)
        );

        // Add system message on first interaction
        if (chatMemory.messages().isEmpty()) {
            SystemMessage systemMsg = SystemMessage.from("""
                You are a helpful assistant in an ongoing conversation.
                
                <conversation_guidelines>
                - Remember previous context from this session
                - Build on earlier discussion points naturally
                - Ask clarifying questions when truly needed
                - Maintain consistent personality and tone throughout
                - Reference prior exchanges when relevant
                </conversation_guidelines>
                
                <response_style>
                - Be concise but complete
                - Use examples when they help understanding
                - Format responses clearly with proper structure
                - Acknowledge the user's previous messages when relevant
                - Show that you understand the conversation flow
                </response_style>
                
                <tool_preambles>
                - If you need to perform multiple steps, outline your plan first
                - Provide updates as you work through complex requests
                - Summarize what you've done at the end
                </tool_preambles>
                """);
            chatMemory.add(systemMsg);
        }

        // Add user message
        chatMemory.add(UserMessage.from(userMessage));

        // Generate response using LangChain4j's proper message handling
        AiMessage aiMessage = chatModel.chat(chatMemory.messages()).aiMessage();
        
        // Store assistant's response in memory
        chatMemory.add(aiMessage);

        return aiMessage.text();
    }

    /**
     * Example 6b: Multi-Turn Conversation with Streaming
     */
    public SseEmitter continueConversationStreaming(String userMessage, String sessionId) {
        SseEmitter emitter = new SseEmitter(600_000L);

        ChatMemory chatMemory = sessionMemories.computeIfAbsent(
            sessionId,
            k -> MessageWindowChatMemory.withMaxMessages(10)
        );

        if (chatMemory.messages().isEmpty()) {
            SystemMessage systemMsg = SystemMessage.from("""
                You are a helpful assistant in an ongoing conversation.
                
                <conversation_guidelines>
                - Remember previous context from this session
                - Build on earlier discussion points naturally
                - Ask clarifying questions when truly needed
                - Maintain consistent personality and tone throughout
                - Reference prior exchanges when relevant
                </conversation_guidelines>
                
                <response_style>
                - Be concise but complete
                - Use examples when they help understanding
                - Format responses clearly with proper structure
                - Acknowledge the user's previous messages when relevant
                - Show that you understand the conversation flow
                </response_style>
                
                <tool_preambles>
                - If you need to perform multiple steps, outline your plan first
                - Provide updates as you work through complex requests
                - Summarize what you've done at the end
                </tool_preambles>
                """);
            chatMemory.add(systemMsg);
        }

        chatMemory.add(UserMessage.from(userMessage));

        ChatRequest request = ChatRequest.builder()
            .messages(chatMemory.messages())
            .build();

        log.info("[STREAM] Starting streaming chat, session: {}", sessionId);

        streamingChatModel.chat(request, new StreamingChatResponseHandler() {
            private final StringBuilder fullResponse = new StringBuilder();
            private int tokenCount = 0;

            @Override
            public void onPartialResponse(String token) {
                tokenCount++;
                fullResponse.append(token);
                if (tokenCount % 50 == 0) {
                    log.info("[STREAM] Chat received {} tokens so far...", tokenCount);
                }
                try {
                    emitter.send(SseEmitter.event()
                            .name("token")
                            .data(token));
                } catch (Exception e) {
                    log.warn("[STREAM] Client disconnected after {} tokens", tokenCount);
                    emitter.completeWithError(e);
                }
            }

            @Override
            public void onCompleteResponse(ChatResponse response) {
                chatMemory.add(response.aiMessage());
                log.info("[STREAM] Chat completed. Total tokens: {}. Response length: {} chars",
                        tokenCount, fullResponse.length());
                try {
                    emitter.send(SseEmitter.event().name("done").data("[DONE]"));
                    emitter.complete();
                } catch (Exception e) {
                    log.warn("[STREAM] Error sending completion event", e);
                }
            }

            @Override
            public void onError(Throwable error) {
                log.error("[STREAM] Chat error after {} tokens: {}",
                        tokenCount, error.getMessage(), error);
                try {
                    emitter.send(SseEmitter.event()
                            .name("error")
                            .data(error.getMessage()));
                } catch (Exception e) {
                    // ignore
                }
                emitter.completeWithError(error);
            }
        });

        return emitter;
    }

    // ==================== EXAMPLE 7: CONSTRAINED OUTPUT ====================

    /**
     * Example 7: Constrained Output Generation
     * Generates output that strictly adheres to constraints.
     */
    public String generateConstrained(String topic, String format, int maxWords) {
        String prompt = """
            <strict_constraints>
            You MUST adhere to these constraints:
            - Topic: %s
            - Format: %s
            - Maximum words: %d
            - Do NOT exceed the word limit
            - Do NOT deviate from the specified format
            </strict_constraints>
            
            <quality_requirements>
            Within the constraints:
            - Be informative and accurate
            - Use clear, professional language
            - Organize content logically
            - Include relevant details
            </quality_requirements>
            
            Generate the content:
            """.formatted(topic, format, maxWords);

        return chatModel.chat(prompt);
    }

    /**
     * Example 7b: Constrained Output with Streaming
     */
    public SseEmitter generateConstrainedStreaming(String topic, String format, int maxWords) {
        String prompt = """
            <strict_constraints>
            You MUST adhere to these constraints:
            - Topic: %s
            - Format: %s
            - Maximum words: %d
            - Do NOT exceed the word limit
            - Do NOT deviate from the specified format
            </strict_constraints>
            
            <quality_requirements>
            Within the constraints:
            - Be informative and accurate
            - Use clear, professional language
            - Organize content logically
            - Include relevant details
            </quality_requirements>
            
            Generate the content:
            """.formatted(topic, format, maxWords);
        return streamResponse(prompt);
    }

    // ==================== EXAMPLE 8: STEP-BY-STEP REASONING ====================

    /**
     * Example 8: Step-by-Step Reasoning
     * Encourages explicit reasoning process.
     */
    public String solveWithReasoning(String problem) {
        String prompt = """
            Solve this problem by explaining your reasoning step by step in your response.
            
            Show me:
            1. How you understand the problem
            2. Your approach to solving it
            3. Each step of your work
            4. Verification that your answer is correct
            
            Important: Write out your step-by-step thinking in your answer, not just the final result.
            
            Problem: %s
            """.formatted(problem);

        return chatModel.chat(prompt);
    }

    /**
     * Example 8b: Step-by-Step Reasoning with Streaming
     */
    public SseEmitter solveWithReasoningStreaming(String problem) {
        String prompt = """
            Solve this problem by explaining your reasoning step by step in your response.
            
            Show me:
            1. How you understand the problem
            2. Your approach to solving it
            3. Each step of your work
            4. Verification that your answer is correct
            
            Important: Write out your step-by-step thinking in your answer, not just the final result.
            
            Problem: %s
            """.formatted(problem);
        return streamResponse(prompt);
    }

    // ==================== SESSION MANAGEMENT ====================

    /**
     * Clear session memory for a specific session.
     */
    public void clearSession(String sessionId) {
        sessionMemories.remove(sessionId);
    }

    /**
     * Clear all session memories.
     */
    public void clearAllSessions() {
        sessionMemories.clear();
    }
}
