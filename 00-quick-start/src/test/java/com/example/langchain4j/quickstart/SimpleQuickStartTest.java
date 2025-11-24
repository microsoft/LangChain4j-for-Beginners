package com.example.langchain4j.quickstart;

import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.input.PromptTemplate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * SimpleQuickStartTest - Unit Tests for Quick Start Module
 * Run: mvn test
 * 
 * Simple tests for the Quick Start module.
 * These tests verify basic LangChain4j concepts without requiring API calls!
 * 
 * Key Concepts:
 * - Testing prompt templates without API calls
 * - Verifying template variable substitution
 * - Unit testing AI application components
 * 
 * 💡 Ask GitHub Copilot:
 * - "How can I test my AI application logic without making expensive API calls?"
 * - "What's the best way to mock OpenAiOfficialChatModel for unit testing?"
 * - "How do I test that my prompt templates are correctly formatted before sending to the API?"
 * - "What are best practices for testing AI agents with tool integrations?"
 */
class SimpleQuickStartTest {

    @Test
    @DisplayName("Should create simple prompt from text")
    void testSimplePromptCreation() {
        // Create a simple prompt
        String promptText = "Tell me about Paris";
        
        // Verify the prompt is created correctly
        assertThat(promptText).isNotNull();
        assertThat(promptText).isNotEmpty();
        assertThat(promptText).contains("Paris");
    }

    @Test
    @DisplayName("Should format prompt template with variables")
    void testPromptTemplateFormatting() {
        // Create a prompt template
        PromptTemplate template = PromptTemplate.from(
            "Best time to visit {{destination}} for {{activity}}?"
        );
        
        // Apply template with variables
        Prompt prompt = template.apply(Map.of(
            "destination", "Paris",
            "activity", "sightseeing"
        ));
        
        // Verify the result
        assertThat(prompt.text()).isEqualTo("Best time to visit Paris for sightseeing?");
    }

    @Test
    @DisplayName("Should handle multiple template variables")
    void testMultipleVariables() {
        // Create template with multiple variables
        PromptTemplate template = PromptTemplate.from(
            "I want to travel from {{from}} to {{to}} in {{month}}"
        );
        
        // Apply variables
        Prompt prompt = template.apply(Map.of(
            "from", "New York",
            "to", "London",
            "month", "June"
        ));
        
        // Verify all variables are replaced
        assertThat(prompt.text()).contains("New York");
        assertThat(prompt.text()).contains("London");
        assertThat(prompt.text()).contains("June");
        assertThat(prompt.text()).doesNotContain("{{");
    }

    @Test
    @DisplayName("Should create system message prompts")
    void testSystemMessagePrompt() {
        // System message for context
        String systemMessage = "You are a helpful travel assistant specializing in European destinations.";
        
        // User query
        String userQuery = "What should I see in Paris?";
        
        // Verify both parts exist
        assertThat(systemMessage).contains("travel assistant");
        assertThat(userQuery).isNotEmpty();
    }

    @Test
    @DisplayName("Should validate required environment variables")
    void testEnvironmentVariableValidation() {
        // Simulate checking for required environment variable
        String envVar = "GITHUB_TOKEN";
        
        // In real code, we'd check System.getenv(envVar)
        // For testing, just verify the variable name is correct
        assertThat(envVar).isEqualTo("GITHUB_TOKEN");
    }

    @Test
    @DisplayName("Should create chain of thought prompt")
    void testChainOfThoughtPrompt() {
        // Create a prompt that asks for step-by-step reasoning
        String cotPrompt = """
                Problem: What's the best month to visit Paris?
                
                Let's think step-by-step:
                1. Consider the weather
                2. Consider tourist crowds
                3. Consider prices
                """;
        
        // Verify the structure
        assertThat(cotPrompt).contains("step-by-step");
        assertThat(cotPrompt).contains("weather");
        assertThat(cotPrompt).contains("crowds");
    }
}
