package com.example.langchain4j.agents.config;

import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openaiofficial.OpenAiOfficialChatModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * LangChain4j configuration for Spring Boot.
 * Provides ChatModel and ChatMemoryProvider beans for automatic wiring.
 */
@Configuration
public class LangChainConfig {

    private static final Logger log = LoggerFactory.getLogger(LangChainConfig.class);

    /**
     * ChatModel bean for Azure OpenAI.
     * Automatically wired into @AiService interfaces by Spring Boot.
     */
    @Bean
    public ChatModel chatModel(
            @Value("${azure.openai.endpoint}") String endpoint,
            @Value("${azure.openai.api-key}") String apiKey,
            @Value("${azure.openai.deployment}") String deployment) {
        
        log.info("Initializing ChatModel with OpenAI Official client");
        log.info("Base URL: {}", endpoint);
        log.info("Model: {}", deployment);
        
        return OpenAiOfficialChatModel.builder()
            .baseUrl(endpoint)
            .apiKey(apiKey)
            .modelName(deployment)
            .maxCompletionTokens(2000)
            .maxRetries(3)
            .build();
    }

    /**
     * ChatMemoryProvider bean for session-based memory management.
     * Automatically used by @AiService interfaces with @MemoryId parameters.
     * Creates a separate memory instance for each session ID.
     */
    @Bean
    public ChatMemoryProvider chatMemoryProvider() {
        log.info("Initializing ChatMemoryProvider with max 20 messages per session");
        return memoryId -> MessageWindowChatMemory.withMaxMessages(20);
    }
}
