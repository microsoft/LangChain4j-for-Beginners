package com.example.langchain4j.config;

import dev.langchain4j.model.openaiofficial.OpenAiOfficialChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * Configuration for LangChain4j with Azure OpenAI using the OpenAI Official client.
 * 
 * The OpenAI Official client supports Azure OpenAI endpoints, providing a unified
 * interface for both OpenAI and Azure OpenAI services.
 */
@Configuration
public class LangChainConfig {

    @Value("${AZURE_OPENAI_ENDPOINT}")
    private String azureEndpoint;

    @Value("${AZURE_OPENAI_API_KEY}")
    private String azureApiKey;

    @Value("${AZURE_OPENAI_DEPLOYMENT}")
    private String deploymentName; // Azure deployment name, used as modelName

    /**
     * Creates the OpenAI Official chat model configured for Azure OpenAI.
     * 
     * @return configured OpenAiOfficialChatModel
     */
    @Bean
    public OpenAiOfficialChatModel openAiOfficialChatModel() {
        return OpenAiOfficialChatModel.builder()
                .baseUrl(azureEndpoint)
                .apiKey(azureApiKey)
                .modelName(deploymentName)
                .timeout(Duration.ofMinutes(5))
                .maxRetries(3)
                .build();
    }
}
