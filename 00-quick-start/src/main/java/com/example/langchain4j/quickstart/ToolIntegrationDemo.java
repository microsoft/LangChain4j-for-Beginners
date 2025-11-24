package com.example.langchain4j.quickstart;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openaiofficial.OpenAiOfficialChatModel;
import dev.langchain4j.service.AiServices;

/**
 * ToolIntegrationDemo - AI Function Calling
 * Run: mvn exec:java -Dexec.mainClass="com.example.langchain4j.quickstart.ToolIntegrationDemo"
 * 
 * This example demonstrates one of the most powerful features of modern LLMs:
 * the ability to call external functions/tools. The AI can:
 * 1. Understand when a tool is needed
 * 2. Extract parameters from natural language
 * 3. Execute the tool and incorporate results
 * 
 * This enables AI agents to perform actions, not just generate text.
 * We'll use a calculator as an example, but this pattern applies to
 * any functionality: databases, APIs, file operations, etc.
 * 
 * Key Concepts:
 * - @Tool annotation for method discovery
 * - AiServices for automatic tool orchestration
 * - Parameter extraction from natural language
 * - Multi-step reasoning with tools
 * 
 * 💡 Ask GitHub Copilot:
 * - "How does the @Tool annotation work and what does LangChain4j do with it behind the scenes?"
 * - "Can the AI call multiple tools in sequence to solve complex problems?"
 * - "What happens if a tool throws an exception - how should I handle errors?"
 * - "How would I integrate a real API (like weather or currency) instead of this calculator example?"
 */
public class ToolIntegrationDemo {

    /**
     * MathToolkit - A collection of mathematical operations
     * Each method annotated with @Tool can be discovered and called by the AI
     */
    static class Calculator {
        
        @Tool("Performs addition of two numeric values")
        public double add(double a, double b) {
            System.out.println("[TOOL] Executing: add(" + a + ", " + b + ")");
            return a + b;
        }

        @Tool("Performs subtraction: first value minus second value")
        public double subtract(double a, double b) {
            System.out.println("[TOOL] Executing: subtract(" + a + ", " + b + ")");
            return a - b;
        }

        @Tool("Performs multiplication of two numeric values")
        public double multiply(double a, double b) {
            System.out.println("[TOOL] Executing: multiply(" + a + ", " + b + ")");
            return a * b;
        }

        @Tool("Performs division: first value divided by second value")
        public double divide(double a, double b) {
            System.out.println("[TOOL] Executing: divide(" + a + ", " + b + ")");
            if (b == 0) {
                throw new IllegalArgumentException("Division by zero is undefined");
            }
            return a / b;
        }

        @Tool("Computes the square root of a number")
        public double squareRoot(double number) {
            System.out.println("[TOOL] Executing: squareRoot(" + number + ")");
            return Math.sqrt(number);
        }
    }

    /**
     * MathAssistant - AI service interface
     * LangChain4j will generate an implementation that bridges chat and tools
     */
    interface MathAssistant {
        String chat(String message);
    }

    public static void main(String[] args) {
        // Ensure authentication token is present
        String githubToken = System.getenv("GITHUB_TOKEN");
        if (githubToken == null || githubToken.isEmpty()) {
            System.err.println("ERROR: Missing required GITHUB_TOKEN environment variable!");
            System.err.println("   Set using: export GITHUB_TOKEN=\"your_token_here\"");
            System.exit(1);
        }

        showHeader("AI Tool Integration Demo");

        // Configure the underlying chat model
        OpenAiOfficialChatModel model = OpenAiOfficialChatModel.builder()
                .baseUrl("https://models.github.ai/inference")
                .apiKey(githubToken)
                .modelName("gpt-4.1-nano")
                .build();

        // Build AI assistant with tool capabilities
        // The assistant can automatically invoke Calculator methods when needed
        MathAssistant assistant = AiServices.builder(MathAssistant.class)
                .chatModel(model)
                .tools(new Calculator())  // Register available tools
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .build();

        // Scenario 1: Basic operation
        System.out.println("\nScenario 1: Simple Arithmetic");
        System.out.println("-".repeat(60));
        String query1 = "Can you calculate 42 plus 58 for me?";
        System.out.println("User: " + query1);
        System.out.println();
        String result1 = assistant.chat(query1);
        System.out.println("Assistant: " + result1);
        System.out.println();

        // Scenario 2: Multi-step reasoning
        System.out.println("Scenario 2: Complex Calculation");
        System.out.println("-".repeat(60));
        String query2 = "I purchased an item for 80 dollars with a 15% discount. What's the final price?";
        System.out.println("User: " + query2);
        System.out.println();
        String result2 = assistant.chat(query2);
        System.out.println("Assistant: " + result2);
        System.out.println();

        // Scenario 3: Advanced function
        System.out.println("Scenario 3: Mathematical Function");
        System.out.println("-".repeat(60));
        String query3 = "Calculate the square root of 256 please";
        System.out.println("User: " + query3);
        System.out.println();
        String result3 = assistant.chat(query3);
        System.out.println("Assistant: " + result3);
        System.out.println();

        System.out.println("[SUCCESS] All tool integration scenarios completed!");
        System.out.println();
        System.out.println("Key Observations:");
        System.out.println("   - AI autonomously selected appropriate tools");
        System.out.println("   - Parameters extracted from conversational language");
        System.out.println("   - Multiple tool calls coordinated automatically");
    }

    private static void showHeader(String title) {
        System.out.println("=".repeat(60));
        System.out.println("  " + title);
        System.out.println("=".repeat(60));
    }
}
