package com.example.langchain4j.service;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.azure.AzureOpenAiChatModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConversationService - Stateful Conversation Management
 * Run: ./start.sh (from module directory, after deploying Azure resources with azd up)
 * 
 * Service for managing conversational interactions with memory.
 * Maintains separate conversation histories for different conversation IDs.
 * 
 * This demonstrates the core difference between stateless and stateful AI:
 * - Without memory: Each request is independent, no context
 * - With memory: MessageWindowChatMemory maintains conversation history
 * 
 * Key Concepts:
 * - MessageWindowChatMemory for conversation context
 * - Per-user conversation isolation with ConcurrentHashMap
 * - UserMessage and AiMessage type safety
 * - Automatic context window management
 * 
 * 💡 Ask GitHub Copilot:
 * - "How does MessageWindowChatMemory decide which messages to drop when the window is full?"
 * - "Can I implement custom memory storage using a database instead of in-memory?"
 * - "What happens if I increase maxMessages beyond the model's token limit?"
 * - "How would I add summarization to compress old conversation history?"
 */
@Service
public class ConversationService {

    private final AzureOpenAiChatModel chatModel;
    private final Map<String, ChatMemory> conversationMemories;
    private static final int MAX_MESSAGES = 10;

    public ConversationService(AzureOpenAiChatModel chatModel) {
        this.chatModel = chatModel;
        this.conversationMemories = new ConcurrentHashMap<>();
    }

    /**
     * Start a new conversation and return a unique conversation ID.
     *
     * @return new conversation ID
     */
    public String startConversation() {
        String conversationId = UUID.randomUUID().toString();
        ChatMemory memory = MessageWindowChatMemory.withMaxMessages(MAX_MESSAGES);
        conversationMemories.put(conversationId, memory);
        return conversationId;
    }

    /**
     * Send a message within an existing conversation.
     *
     * @param conversationId the conversation ID
     * @param message the user message
     * @return AI response
     */
    public String chat(String conversationId, String message) {
        ChatMemory memory = conversationMemories.computeIfAbsent(
            conversationId,
            id -> MessageWindowChatMemory.withMaxMessages(MAX_MESSAGES)
        );

        // Add user message to memory
        UserMessage userMessage = UserMessage.from(message);
        memory.add(userMessage);

        // Get all messages for context
        List<ChatMessage> messages = memory.messages();

        // Generate response using chat method with message list
        AiMessage aiMessage = chatModel.chat(messages).aiMessage();

        // Add AI response to memory
        memory.add(aiMessage);

        return aiMessage.text();
    }

    /**
     * Get conversation history for a given conversation ID.
     *
     * @param conversationId the conversation ID
     * @return list of chat messages
     */
    public List<ChatMessage> getHistory(String conversationId) {
        ChatMemory memory = conversationMemories.get(conversationId);
        return memory != null ? memory.messages() : List.of();
    }

    /**
     * Clear conversation history for a given conversation ID.
     *
     * @param conversationId the conversation ID
     */
    public void clearConversation(String conversationId) {
        conversationMemories.remove(conversationId);
    }

    /**
     * Check if a conversation exists.
     *
     * @param conversationId the conversation ID
     * @return true if conversation exists
     */
    public boolean conversationExists(String conversationId) {
        return conversationMemories.containsKey(conversationId);
    }
}
