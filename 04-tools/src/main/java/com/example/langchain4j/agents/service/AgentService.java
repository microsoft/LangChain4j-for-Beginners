package com.example.langchain4j.agents.service;

import com.example.langchain4j.agents.model.dto.AgentRequest;
import com.example.langchain4j.agents.model.dto.AgentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * AgentService - Improved Implementation Using Declarative AI Services
 * Run: ./start.sh (from module directory, after deploying Azure resources with azd up)
 * 
 * Agent service using LangChain4j declarative AI Services with Spring Boot integration.
 * Demonstrates best practices:
 * - Declarative @AiService interface with @MemoryId for automatic session management
 * - Spring Boot auto-wiring of ChatModel and tools
 * - No manual memory management (handled by ChatMemoryProvider)
 * - Single Assistant instance (not recreated on every call)
 *
 * 💡 Ask GitHub Copilot:
 * - "How does @MemoryId work internally in LangChain4j?"
 * - "What are the benefits of declarative AI Services over manual AiServices.builder()?"
 * - "How does Spring Boot auto-wire ChatModel and tools?"
 * - "How can I customize the ChatMemoryProvider?"
 */
@Service
public class AgentService {

    private static final Logger log = LoggerFactory.getLogger(AgentService.class);
    
    private final Assistant assistant;

    /**
     * Constructor with auto-wired Assistant.
     * Spring Boot automatically creates the Assistant bean from the @AiService interface.
     */
    public AgentService(Assistant assistant) {
        this.assistant = assistant;
        log.info("Agent service initialized with declarative AI Service");
    }

    /**
     * Create a new agent session.
     * Returns a new UUID that will be used as the @MemoryId.
     */
    public String createAgentSession() {
        String sessionId = UUID.randomUUID().toString();
        log.info("Created new agent session: {}", sessionId);
        // Note: No need to manually create ChatMemory - ChatMemoryProvider handles it
        return sessionId;
    }

    /**
     * Execute an agent task using declarative AI Service with automatic tool orchestration.
     * The @MemoryId in the Assistant interface automatically manages session-based memory.
     */
    public AgentResponse executeTask(AgentRequest request) {
        log.info("Executing agent task: {}", request.message());
        
        String sessionId = request.sessionId();
        if (sessionId == null) {
            sessionId = createAgentSession();
        }
        
        try {
            // Call the declarative Assistant with sessionId for memory management
            // LangChain4j automatically:
            // - Creates/retrieves ChatMemory for this sessionId via ChatMemoryProvider
            // - Generates function schemas from @Tool annotations
            // - Detects when model wants to call a function
            // - Executes the Java method directly
            // - Handles multi-turn conversations
            // - Manages errors and retries
            String answer = assistant.chat(sessionId, request.message());
            
            log.info("Agent completed task successfully");
            
            return new AgentResponse(
                answer,
                sessionId,
                new ArrayList<>(), // Tool execution details tracked by LangChain4j logging
                "completed"
            );
            
        } catch (Exception e) {
            log.error("Agent task execution failed", e);
            return new AgentResponse(
                "I encountered an error: " + e.getMessage(),
                sessionId,
                new ArrayList<>(),
                "failed"
            );
        }
    }

    /**
     * Simple chat for health checks.
     * Uses a dedicated session ID for health checks.
     */
    public String simpleChat(String message) {
        try {
            return assistant.chat("health-check", message);
        } catch (Exception e) {
            log.error("Simple chat failed", e);
            return "Error: " + e.getMessage();
        }
    }

    /**
     * Get available tools.
     */
    public List<String> getAvailableTools() {
        return List.of(
            "getCurrentWeather - Get current weather for a location",
            "getWeatherForecast - Get weather forecast",
            "celsiusToFahrenheit - Convert Celsius to Fahrenheit",
            "fahrenheitToCelsius - Convert Fahrenheit to Celsius",
            "celsiusToKelvin - Convert Celsius to Kelvin",
            "kelvinToCelsius - Convert Kelvin to Celsius",
            "fahrenheitToKelvin - Convert Fahrenheit to Kelvin",
            "kelvinToFahrenheit - Convert Kelvin to Fahrenheit"
        );
    }

    /**
     * Clear agent session.
     * Note: With ChatMemoryProvider managing memory lifecycle, sessions are automatically
     * garbage collected when no longer referenced. For explicit cleanup, you could
     * implement a custom ChatMemoryStore with eviction support.
     */
    public void clearSession(String sessionId) {
        log.info("Session marked for cleanup: {}", sessionId);
        log.debug("Memory will be garbage collected when session is no longer used");
        // Note: ChatMemoryProvider creates memory on-demand, so no explicit cleanup needed
        // For production use, consider implementing a ChatMemoryStore with TTL or eviction
    }
}
