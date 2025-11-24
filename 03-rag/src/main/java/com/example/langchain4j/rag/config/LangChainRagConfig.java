package com.example.langchain4j.rag.config;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.openaiofficial.OpenAiOfficialChatModel;
import dev.langchain4j.model.openaiofficial.OpenAiOfficialEmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Configuration class for LangChain4j RAG components.
 * Provides beans for chat model, embedding model, and vector stores.
 */
@Configuration
public class LangChainRagConfig {

    @Value("${azure.openai.endpoint}")
    private String endpoint;

    @Value("${azure.openai.api-key}")
    private String apiKey;

    @Value("${azure.openai.deployment}")
    private String deployment;

    @Value("${azure.openai.embedding-deployment}")
    private String embeddingDeployment;

    @Value("${azure.openai.reasoning-effort:medium}")
    private String reasoningEffort;

    @Value("${azure.openai.max-completion-tokens:2000}")
    private Integer maxCompletionTokens;

    /**
     * Creates the OpenAI Official Chat Model for answer generation.
     * GPT-5 uses reasoning effort levels instead of temperature.
     *
     * @return configured OpenAiOfficialChatModel
     */
    @Bean
    public OpenAiOfficialChatModel chatModel() {
        return OpenAiOfficialChatModel.builder()
            .baseUrl(endpoint)
            .apiKey(apiKey)
            .modelName(deployment)
            .maxCompletionTokens(maxCompletionTokens)
            .maxRetries(3)
            .build();
    }

    /**
     * Creates the OpenAI Official Embedding Model for document vectorization.
     *
     * @return configured OpenAiOfficialEmbeddingModel
     */
    @Bean
    public OpenAiOfficialEmbeddingModel embeddingModel() {
        return OpenAiOfficialEmbeddingModel.builder()
            .baseUrl(endpoint)
            .apiKey(apiKey)
            .modelName(embeddingDeployment)
            .maxRetries(3)
            .build();
    }

    /**
     * Creates an in-memory embedding store for development.
     * This store loses all data when the application restarts.
     *
     * @return in-memory embedding store
     */
    @Bean
    @Profile({"default", "dev"})
    public EmbeddingStore<TextSegment> inMemoryEmbeddingStore() {
        return new InMemoryEmbeddingStore<>();
    }
}
