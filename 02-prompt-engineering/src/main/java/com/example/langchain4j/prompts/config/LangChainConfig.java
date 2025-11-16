package com.example.langchain4j.prompts.config;

import dev.langchain4j.model.azure.AzureOpenAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.Duration;

/**
 * Configuration for LangChain4j with GPT-5 support.
 * 
 * Note: For GPT-5 reasoning effort is controlled through prompt engineering
 * rather than model configuration parameters. See Gpt5PromptService for examples of how to
 * use prompts like "<reasoning_effort>low</reasoning_effort>" to control model behavior.
 * 
 */
@Configuration
public class LangChainConfig {

    @Value("${azure.openai.endpoint}")
    private String azureEndpoint;

    @Value("${azure.openai.api-key}")
    private String azureApiKey;

    @Value("${azure.openai.deployment:gpt-5}")
    private String deploymentName;

    @Value("${azure.openai.max-completion-tokens:2000}")
    private Integer maxCompletionTokens;

    /**
     * Primary chat model for general use.
     */
    @Bean
    @Primary
    public AzureOpenAiChatModel chatLanguageModel() {
        return AzureOpenAiChatModel.builder()
                .endpoint(azureEndpoint)
                .apiKey(azureApiKey)
                .deploymentName(deploymentName)
                .maxCompletionTokens(maxCompletionTokens)
                .timeout(Duration.ofMinutes(5))  // GPT-5 reasoning can take time
                .logRequestsAndResponses(true)
                .build();
    }
}
