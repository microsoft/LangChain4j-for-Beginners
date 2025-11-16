package com.example.langchain4j.prompts.service;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.model.azure.AzureOpenAiChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

/**
 * Simple tests for Gpt5PromptService demonstrating GPT-5 prompting patterns.
 * These tests validate that prompts are structured correctly according to best practices.
 * 
 * Testing Philosophy for Beginners:
 * - Uses Mockito to mock AzureOpenAiChatModel
 * - ArgumentCaptor captures the actual prompt sent to the model
 * - Tests verify prompt structure contains expected GPT-5 patterns
 * - Doesn't require real LLM - keeps tests fast and deterministic
 * - Validates prompt engineering patterns, not AI responses
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@DisplayName("GPT-5 Prompt Engineering Tests")
class SimpleGpt5PromptTest {

    private Gpt5PromptService promptService;
    
    @Mock
    private AzureOpenAiChatModel mockChatModel;
    
    private ArgumentCaptor<String> promptCaptor;

    @BeforeEach
    void setUp() {
        promptCaptor = ArgumentCaptor.forClass(String.class);
        
        // Default mock behavior for string chat
        when(mockChatModel.chat(anyString())).thenReturn("Mocked response");
        
        // Mock behavior for list-based chat (used in multi-turn conversations)
        ChatResponse mockResponse = ChatResponse.builder()
            .aiMessage(AiMessage.from("Mocked response"))
            .build();
        when(mockChatModel.chat(anyList())).thenReturn(mockResponse);
        
        promptService = new Gpt5PromptService();
        // Use reflection to inject the mock (since it uses @Autowired)
        setField(promptService, "chatModel", mockChatModel);
    }

    @Test
    @DisplayName("Should generate low eagerness prompt with search depth constraint")
    void shouldGenerateLowEagernessPrompt() {
        // Given
        String problem = "What is 2 + 2?";

        // When
        String response = promptService.solveFocused(problem);

        // Then
        verify(mockChatModel).chat(promptCaptor.capture());
        String actualPrompt = promptCaptor.getValue();
        
        assertThat(actualPrompt)
            .contains("<context_gathering>")
            .contains("Search depth: very low")
            .contains("2 reasoning steps")
            .contains(problem);
    }

    @Test
    @DisplayName("Should generate high eagerness prompt for autonomous solving")
    void shouldGenerateHighEagernessPrompt() {
        // Given
        String problem = "Design a scalable microservices architecture";

        // When
        String response = promptService.solveAutonomous(problem);

        // Then
        verify(mockChatModel).chat(promptCaptor.capture());
        String actualPrompt = promptCaptor.getValue();
        
        assertThat(actualPrompt)
            .contains("thoroughly")
            .contains("comprehensive solution")
            .contains("multiple approaches")
            .contains(problem);
    }

    @Test
    @DisplayName("Should generate prompt with task execution preambles")
    void shouldGeneratePromptWithPreambles() {
        // Given
        String task = "Create a REST API for user management";

        // When
        String response = promptService.executeWithPreamble(task);

        // Then
        verify(mockChatModel).chat(promptCaptor.capture());
        String actualPrompt = promptCaptor.getValue();
        
        assertThat(actualPrompt)
            .contains("<task_execution>")
            .contains("<tool_preambles>")
            .contains("restate the user's goal")
            .contains("step-by-step plan")
            .contains(task);
    }

    @Test
    @DisplayName("Should generate code prompt with self-reflection rubric")
    void shouldGenerateCodeWithReflectionPrompt() {
        // Given
        String requirement = "Create a Spring Boot REST controller for products";

        // When
        String response = promptService.generateCodeWithReflection(requirement);

        // Then
        verify(mockChatModel).chat(promptCaptor.capture());
        String actualPrompt = promptCaptor.getValue();
        
        assertThat(actualPrompt)
            .contains("Generate Java code")
            .contains("simple")
            .contains("error handling")
            .contains(requirement);
    }

    @Test
    @DisplayName("Should generate structured analysis prompt")
    void shouldGenerateStructuredAnalysisPrompt() {
        // Given
        String code = "public void process() { System.out.println(\"test\"); }";

        // When
        String response = promptService.analyzeCode(code);

        // Then
        verify(mockChatModel).chat(promptCaptor.capture());
        String actualPrompt = promptCaptor.getValue();
        
        assertThat(actualPrompt)
            .contains("<analysis_framework>")
            .contains("<output_format>")
            .contains("Correctness")
            .contains("Best Practices")
            .contains("Performance")
            .contains("Security")
            .contains("Maintainability")
            .contains(code);
    }

    @Test
    @DisplayName("Should maintain conversation context across multiple turns")
    void shouldMaintainConversationContext() {
        // Given
        String sessionId = "test-session";
        ChatResponse firstResponse = ChatResponse.builder()
            .aiMessage(AiMessage.from("First response"))
            .build();
        ChatResponse secondResponse = ChatResponse.builder()
            .aiMessage(AiMessage.from("Second response"))
            .build();
        when(mockChatModel.chat(anyList()))
            .thenReturn(firstResponse)
            .thenReturn(secondResponse);

        // When
        promptService.continueConversation("Hello", sessionId);
        promptService.continueConversation("Tell me more", sessionId);

        // Then
        @SuppressWarnings("unchecked")
        ArgumentCaptor<List<ChatMessage>> messagesCaptor = ArgumentCaptor.forClass(List.class);
        verify(mockChatModel, times(2)).chat(messagesCaptor.capture());
        
        List<ChatMessage> secondCallMessages = messagesCaptor.getAllValues().get(1);
        
        // Should have: System message, first user message, first AI response, second user message
        assertThat(secondCallMessages).hasSizeGreaterThanOrEqualTo(4);
    }

    @Test
    @DisplayName("Should include conversation guidelines in first message")
    void shouldIncludeConversationGuidelinesInFirstMessage() {
        // Given
        String sessionId = "new-session";

        // When
        promptService.continueConversation("First message", sessionId);

        // Then
        @SuppressWarnings("unchecked")
        ArgumentCaptor<List<ChatMessage>> messagesCaptor = ArgumentCaptor.forClass(List.class);
        verify(mockChatModel).chat(messagesCaptor.capture());
        List<ChatMessage> messages = messagesCaptor.getValue();
        
        // Should have system message and user message
        assertThat(messages).hasSizeGreaterThanOrEqualTo(2);
        
        // First message should be system message with guidelines
        ChatMessage firstMessage = messages.get(0);
        assertThat(firstMessage).isInstanceOf(SystemMessage.class);
        assertThat(((SystemMessage)firstMessage).text())
            .contains("<conversation_guidelines>")
            .contains("<response_style>")
            .contains("<tool_preambles>")
            .contains("Remember previous context");
    }

    @Test
    @DisplayName("Should generate constrained output prompt with strict limits")
    void shouldGenerateConstrainedPrompt() {
        // Given
        String topic = "Java Streams";
        String format = "bullet points";
        int maxWords = 50;

        // When
        String response = promptService.generateConstrained(topic, format, maxWords);

        // Then
        verify(mockChatModel).chat(promptCaptor.capture());
        String actualPrompt = promptCaptor.getValue();
        
        assertThat(actualPrompt)
            .contains("<strict_constraints>")
            .contains(topic)
            .contains(format)
            .contains(String.valueOf(maxWords))
            .contains("MUST adhere")
            .contains("Do NOT exceed");
    }

    @Test
    @DisplayName("Should generate step-by-step reasoning prompt")
    void shouldGenerateReasoningPrompt() {
        // Given
        String problem = "Calculate the compound interest";

        // When
        String response = promptService.solveWithReasoning(problem);

        // Then
        verify(mockChatModel).chat(promptCaptor.capture());
        String actualPrompt = promptCaptor.getValue();
        
        assertThat(actualPrompt)
            .contains("step by step")
            .contains("understand the problem")
            .contains("approach to solving")
            .contains("Verification")
            .contains(problem);
    }

    @Test
    @DisplayName("Should clear session memory")
    void shouldClearSessionMemory() {
        // Given
        String sessionId = "session-to-clear";
        promptService.continueConversation("Test message", sessionId);

        // When
        promptService.clearSession(sessionId);
        promptService.continueConversation("New message", sessionId);

        // Then - Should start fresh without previous context
        @SuppressWarnings("unchecked")
        ArgumentCaptor<List<ChatMessage>> messagesCaptor = ArgumentCaptor.forClass(List.class);
        verify(mockChatModel, times(2)).chat(messagesCaptor.capture());
        
        List<ChatMessage> newSessionMessages = messagesCaptor.getAllValues().get(1);
        
        // After clearing, should only have system message and new user message (not old messages)
        assertThat(newSessionMessages.size()).isLessThanOrEqualTo(3);
    }

    @Test
    @DisplayName("Should clear all sessions")
    void shouldClearAllSessions() {
        // Given
        promptService.continueConversation("Message 1", "session-1");
        promptService.continueConversation("Message 2", "session-2");

        // When
        promptService.clearAllSessions();
        
        // Then - New conversations should start fresh
        reset(mockChatModel);
        ChatResponse freshResponse = ChatResponse.builder()
            .aiMessage(AiMessage.from("Fresh response"))
            .build();
        when(mockChatModel.chat(anyList())).thenReturn(freshResponse);
        
        promptService.continueConversation("New message 1", "session-1");
        
        @SuppressWarnings("unchecked")
        ArgumentCaptor<List<ChatMessage>> messagesCaptor = ArgumentCaptor.forClass(List.class);
        verify(mockChatModel).chat(messagesCaptor.capture());
        List<ChatMessage> newMessages = messagesCaptor.getValue();
        
        // Should start fresh with only system + new message
        assertThat(newMessages.size()).isLessThanOrEqualTo(3);
    }

    @Test
    @DisplayName("Should validate all GPT-5 prompting patterns are present")
    void shouldContainAllGpt5Patterns() {
        // Test that key GPT-5 patterns are used throughout the service
        
        // 1. Low eagerness
        promptService.solveFocused("test");
        verify(mockChatModel, times(1)).chat(contains("context_gathering"));
        
        // 2. Self-reflection (simplified in our implementation)
        reset(mockChatModel);
        when(mockChatModel.chat(anyString())).thenReturn("response");
        promptService.generateCodeWithReflection("test");
        verify(mockChatModel, times(1)).chat(contains("production-quality"));
        
        // 3. Structured output
        reset(mockChatModel);
        when(mockChatModel.chat(anyString())).thenReturn("response");
        promptService.analyzeCode("test");
        verify(mockChatModel, times(1)).chat(contains("analysis_framework"));
    }

    /**
     * Helper method to set private field using reflection
     * (Simple alternative to @InjectMocks for @Autowired fields)
     */
    private void setField(Object target, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception e) {
            throw new RuntimeException("Failed to set field " + fieldName, e);
        }
    }
}
