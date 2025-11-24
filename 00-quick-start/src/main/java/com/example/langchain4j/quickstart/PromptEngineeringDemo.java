package com.example.langchain4j.quickstart;

import dev.langchain4j.model.openaiofficial.OpenAiOfficialChatModel;

/**
 * PromptEngineeringDemo - Basic Prompt Engineering Patterns
 * Run: mvn exec:java -Dexec.mainClass="com.example.langchain4j.quickstart.PromptEngineeringDemo"
 * 
 * This demonstrates fundamental prompt engineering techniques that improve AI responses:
 * 
 * 1. Zero-shot prompting - Direct task instruction without examples
 * 2. Few-shot prompting - Providing examples to guide the model
 * 3. Chain of thought - Asking the model to show its reasoning
 * 4. Role-based prompting - Setting context and persona
 * 
 * Uses GitHub Models (gpt-4.1-nano) which works better with rate limits
 * than larger models for simple demonstrations.
 * 
 * Key Concepts:
 * - Different prompting strategies
 * - Temperature parameter for response variability
 * - Prompt structure and formatting
 * 
 * 💡 Ask GitHub Copilot:
 * - "What's the difference between zero-shot and few-shot prompting, and when should I use each?"
 * - "How does the temperature parameter affect the model's responses?"
 * - "What are some techniques to prevent prompt injection attacks in production?"
 * - "How can I create reusable PromptTemplate objects for common patterns?"
 */
public class PromptEngineeringDemo {

    public static void main(String[] args) {
        // Verify GitHub token is available
        String githubToken = System.getenv("GITHUB_TOKEN");
        if (githubToken == null || githubToken.isEmpty()) {
            System.err.println("ERROR: GITHUB_TOKEN not found in environment!");
            System.err.println("   Configure with: export GITHUB_TOKEN=\"your_token_here\"");
            System.exit(1);
        }

        displayHeader("Prompt Engineering Patterns Demo");

        // Build non-streaming model for simpler, rate-limit friendly requests
        OpenAiOfficialChatModel model = OpenAiOfficialChatModel.builder()
                .baseUrl("https://models.github.ai/inference")
                .apiKey(githubToken)
                .modelName("gpt-4.1-nano")
                .temperature(0.7)
                .build();

        // Pattern 1: Zero-shot - Direct instruction
        demonstrateZeroShot(model);
        
        // Pattern 2: Few-shot - Learning from examples
        demonstrateFewShot(model);
        
        // Pattern 3: Chain of Thought - Show reasoning
        demonstrateChainOfThought(model);
        
        // Pattern 4: Role-based - Setting context
        demonstrateRoleBased(model);
    }

    /**
     * Pattern 1: Zero-shot Prompting
     * Direct task instruction without examples
     */
    private static void demonstrateZeroShot(OpenAiOfficialChatModel model) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("PATTERN 1: Zero-Shot Prompting");
        System.out.println("=".repeat(60));
        System.out.println("Simple, direct instructions without examples");
        System.out.println();

        String prompt = "Classify this sentiment: 'I absolutely loved the movie!'";
        System.out.println("Prompt: " + prompt);
        System.out.println();
        
        String response = model.chat(prompt);
        System.out.println("Response: " + response);
    }

    /**
     * Pattern 2: Few-Shot Prompting
     * Provide examples to guide the model's behavior
     */
    private static void demonstrateFewShot(OpenAiOfficialChatModel model) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("PATTERN 2: Few-Shot Prompting");
        System.out.println("=".repeat(60));
        System.out.println("Learning from examples to understand the pattern");
        System.out.println();

        String prompt = """
                Classify the sentiment as positive, negative, or neutral.
                
                Examples:
                Text: "This product exceeded my expectations!" → Positive
                Text: "It's okay, nothing special." → Neutral
                Text: "Waste of money, very disappointed." → Negative
                
                Now classify this:
                Text: "Best purchase I've made all year!"
                """;
        
        System.out.println("Prompt with examples:");
        System.out.println(prompt);
        
        String response = model.chat(prompt);
        System.out.println("Response: " + response);
    }

    /**
     * Pattern 3: Chain of Thought
     * Ask the model to explain its reasoning step-by-step
     */
    private static void demonstrateChainOfThought(OpenAiOfficialChatModel model) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("PATTERN 3: Chain of Thought");
        System.out.println("=".repeat(60));
        System.out.println("Asking the model to show its reasoning process");
        System.out.println();

        String prompt = """
                Problem: A store has 15 apples. They sell 8 apples and then 
                receive a shipment of 12 more apples. How many apples do they have now?
                
                Let's solve this step-by-step:
                """;
        
        System.out.println("Prompt: " + prompt);
        
        String response = model.chat(prompt);
        System.out.println("Response: " + response);
    }

    /**
     * Pattern 4: Role-Based Prompting
     * Set a specific persona/context for the AI
     */
    private static void demonstrateRoleBased(OpenAiOfficialChatModel model) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("PATTERN 4: Role-Based Prompting");
        System.out.println("=".repeat(60));
        System.out.println("Setting context and persona for specialized responses");
        System.out.println();

        String prompt = """
                You are an experienced software architect reviewing code.
                Provide a brief code review for this function:
                
                def calculate_total(items):
                    total = 0
                    for item in items:
                        total = total + item['price']
                    return total
                """;
        
        System.out.println("Prompt with role:");
        System.out.println(prompt);
        
        String response = model.chat(prompt);
        System.out.println("Response: " + response);
    }

    private static void displayHeader(String title) {
        System.out.println("=".repeat(60));
        System.out.println("  " + title);
        System.out.println("=".repeat(60));
        System.out.println();
    }
}
