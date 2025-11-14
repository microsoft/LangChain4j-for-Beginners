package com.example.langchain4j.agents.service;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.azure.AzureOpenAiChatModel;
import dev.langchain4j.service.AiServices;
import com.example.langchain4j.agents.model.dto.AgentRequest;
import com.example.langchain4j.agents.model.dto.AgentResponse;
import com.example.langchain4j.agents.tools.WeatherTool;
import com.example.langchain4j.agents.tools.TemperatureTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * AgentService - Correct Implementation Using LangChain4j AiServices
 * Run: ./start.sh (from module directory, after deploying Azure resources with azd up)
 * 
 * Agent service using LangChain4j with Azure OpenAI and native tool calling.
 * Uses AiServices framework for automatic tool orchestration.
 * 
 * Key Concepts:
 * - AiServices builder pattern with .tools() registration
 * - Automatic function schema generation from @Tool annotations
 * - Direct Java method execution (no HTTP calls)
 * - Multi-turn orchestration handled by framework
 * - Session-based conversation memory
 * 
 * 💡 Ask GitHub Copilot:
 * - "How does AiServices.builder().tools() work under the hood?"
 * - "What's the difference between this and manual tool orchestration?"
 * - "How does LangChain4j handle function calling with Azure OpenAI?"
 * - "How can I add custom tool execution logging or monitoring?"
 */
@Service
public class AgentService {

    private static final Logger log = LoggerFactory.getLogger(AgentService.class);
    
    private final AzureOpenAiChatModel chatModel;
    private final WeatherTool weatherTool;
    private final TemperatureTool temperatureTool;
    
    // Session management
    private final ConcurrentHashMap<String, ChatMemory> sessionMemories = new ConcurrentHashMap<>();

    public AgentService(
            @Value("${azure.openai.endpoint}") String endpoint,
            @Value("${azure.openai.api-key}") String apiKey,
            @Value("${azure.openai.deployment}") String deployment,
            WeatherTool weatherTool,
            TemperatureTool temperatureTool) {
        
        this.weatherTool = weatherTool;
        this.temperatureTool = temperatureTool;
        
        log.info("Initializing Agent Service with Azure OpenAI");
        log.info("Endpoint: {}", endpoint);
        log.info("Deployment: {}", deployment);
        
        // Initialize Azure OpenAI chat model
        this.chatModel = AzureOpenAiChatModel.builder()
            .endpoint(endpoint)
            .apiKey(apiKey)
            .deploymentName(deployment)
            .maxCompletionTokens(2000)
            .maxRetries(3)
            .logRequestsAndResponses(true)
            .build();
        
        log.info("Agent service initialized successfully");
    }

    /**
     * Create a new agent session.
     */
    public String createAgentSession() {
        String sessionId = UUID.randomUUID().toString();
        ChatMemory memory = MessageWindowChatMemory.withMaxMessages(20);
        sessionMemories.put(sessionId, memory);
        log.info("Created new agent session: {}", sessionId);
        return sessionId;
    }

    /**
     * Execute an agent task using LangChain4j AiServices with automatic tool orchestration.
     */
    public AgentResponse executeTask(AgentRequest request) {
        log.info("Executing agent task: {}", request.message());
        
        String sessionId = request.sessionId();
        if (sessionId == null) {
            sessionId = createAgentSession();
        }
        
        ChatMemory memory = sessionMemories.computeIfAbsent(
            sessionId,
            id -> MessageWindowChatMemory.withMaxMessages(20)
        );
        
        try {
            // Define AI Service interface
            interface Assistant {
                String chat(String userMessage);
            }
            
            // Create AI Service with tool support
            // LangChain4j automatically:
            // - Generates function schemas from @Tool annotations
            // - Detects when model wants to call a function
            // - Executes the Java method directly
            // - Handles multi-turn conversations
            // - Manages errors and retries
            Assistant assistant = AiServices.builder(Assistant.class)
                .chatModel(chatModel)
                .chatMemory(memory)
                .tools(weatherTool, temperatureTool)
                .build();
            
            // Execute - framework handles all tool orchestration automatically
            String answer = assistant.chat(request.message());
            
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
     */
    public String simpleChat(String message) {
        try {
            return chatModel.chat(message);
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
     */
    public void clearSession(String sessionId) {
        sessionMemories.remove(sessionId);
        log.info("Cleared session: {}", sessionId);
    }
}
