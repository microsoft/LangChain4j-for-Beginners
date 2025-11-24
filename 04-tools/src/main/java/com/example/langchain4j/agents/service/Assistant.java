package com.example.langchain4j.agents.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

/**
 * Declarative AI Service interface for the assistant.
 * Automatically wired by Spring Boot with ChatModel, tools, and memory provider.
 * 
 * The @AiService annotation enables Spring Boot integration.
 * The @MemoryId parameter enables automatic session-based memory management.
 * 
 * Spring Boot will automatically:
 * - Create an implementation of this interface
 * - Wire the ChatModel bean
 * - Wire all @Tool methods from @Component classes (WeatherTool, TemperatureTool)
 * - Use the ChatMemoryProvider bean for session-based memory
 */
@AiService
public interface Assistant {
    
    /**
     * Chat with the assistant.
     * 
     * @param sessionId The session ID for memory management (automatically handled by ChatMemoryProvider)
     * @param message The user message
     * @return The assistant's response
     */
    String chat(@MemoryId String sessionId, @UserMessage String message);
}
