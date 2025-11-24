package com.example.langchain4j.quickstart;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import dev.langchain4j.model.openaiofficial.OpenAiOfficialChatModel;

/**
 * SimpleReaderDemo - Introduction to RAG (Retrieval-Augmented Generation)
 * Run: mvn exec:java -Dexec.mainClass="com.example.langchain4j.quickstart.SimpleReaderDemo"
 * 
 * A simple RAG (Retrieval-Augmented Generation) demonstration that reads a document
 * and allows users to ask questions about its content.
 * 
 * RAG combines two approaches:
 * 1. RETRIEVAL: Finding relevant information from a knowledge source (our document)
 * 2. GENERATION: Using AI to generate answers based on that retrieved information
 * 
 * This prevents the AI from "hallucinating" (making up) answers by giving it
 * specific context to work with.
 * 
 * Key Concepts:
 * - Document loading and retrieval
 * - Context-aware prompting
 * - Grounding responses in specific content
 * 
 * 💡 Ask GitHub Copilot:
 * - "How does RAG prevent AI hallucinations compared to using the model's training data?"
 * - "What's the difference between this simple approach and using vector embeddings?"
 * - "How would I scale this to handle multiple documents or larger knowledge bases?"
 * - "What are best practices for structuring the prompt to ensure the AI uses only the provided context?"
 */
public class SimpleReaderDemo {

    public static void main(String[] args) throws IOException {
        // GitHub Models endpoint - provides access to various AI models
        String endpoint = "https://models.github.ai/inference";
        // PAT = Personal Access Token - this authenticates us with GitHub Models
        String apiKey = System.getenv("GITHUB_TOKEN");
        
        // Validate API key
        if (apiKey == null || apiKey.trim().isEmpty()) {
            System.err.println("Error: GITHUB_TOKEN environment variable is not set or is empty.");
            System.exit(1);
        }

        // RETRIEVAL STEP: Load the document that will serve as our knowledge base
        // In a real RAG system, this might be a database, vector store, or document collection
        // Find document.txt by checking multiple possible locations
        String[] possiblePaths = {
            "document.txt",
            "examples/document.txt", 
            "00-quick-start/document.txt"
        };
        
        String doc = null;
        for (String path : possiblePaths) {
            if (Files.exists(Paths.get(path))) {
                doc = Files.readString(Paths.get(path));
                System.out.println("Found document at: " + path);
                break;
            }
        }
        
        if (doc == null) {
            // Create a sample document if none exists
            doc = """
                Sample Document Content:
                
                LangChain4j is a Java library for building AI-powered applications.
                It provides abstractions for working with various LLM providers.
                The library supports chat models, embeddings, and RAG implementations.
                
                Key features include:
                - Integration with multiple AI providers
                - Support for function calling
                - Built-in memory management
                - Vector store integrations
                """;
            System.out.println("Using sample document content (document.txt not found)");
        }

        // Use try-with-resources to ensure Scanner is properly closed
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ask a question about the document: ");
            String question = scanner.nextLine();
            
            // Validate question input
            if (question == null || question.trim().isEmpty()) {
                System.err.println("Error: No question provided.");
                return;
            }

            // Create the LangChain4j chat model using OpenAI-compatible endpoint
            OpenAiOfficialChatModel chatModel = OpenAiOfficialChatModel.builder()
                    .baseUrl(endpoint)
                    .apiKey(apiKey)
                    .modelName("gpt-4.1-nano")
                    .build();

            // GENERATION STEP: Construct the prompt with both context and question
            // This is the key to RAG - we provide the AI with specific context
            // The triple quotes (""") help the AI clearly separate context from question
            String prompt = String.format("""
                    You are a helpful assistant. Use only the CONTEXT to answer. 
                    If the answer is not in the context, say 'I cannot find that information in the provided document.'
                    
                    CONTEXT:
                    \"\"\"
                    %s
                    \"\"\"
                    
                    QUESTION:
                    %s
                    """, doc, question);

            try {
                // Send the RAG request: AI will generate answer based on our document
                String response = chatModel.chat(prompt);
                
                // Display the AI's response
                System.out.println("\nAssistant: " + response);
            } catch (Exception e) {
                // Handle network errors, API errors, or authentication issues
                System.err.println("Error calling the API: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
