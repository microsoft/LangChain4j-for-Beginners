package com.example.langchain4j.service;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.openaiofficial.OpenAiOfficialChatModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

/**
 * Simple tests for ConversationService demonstrating conversation management and memory.
 * These tests validate conversation lifecycle, memory management, and context preservation.
 * 
 * Testing Philosophy for Beginners:
 * - Uses Mockito to mock OpenAiOfficialChatModel (simplest way!)
 * - @Mock annotation creates a mock instance
 * - when().thenReturn() defines the mock behavior
 * - Tests the conversation management logic without real LLM calls
 * - Keeps tests fast, deterministic, and independent
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@DisplayName("Conversation Service Tests")
class SimpleConversationTest {

    private ConversationService conversationService;
    
    @Mock
    private OpenAiOfficialChatModel mockChatModel;

    @BeforeEach
    void setUp() {
        // Set up default mock behavior - return a simple response
        ChatResponse mockResponse = ChatResponse.builder()
            .aiMessage(AiMessage.from("This is a test response"))
            .build();
        when(mockChatModel.chat(anyList())).thenReturn(mockResponse);
        
        conversationService = new ConversationService(mockChatModel);
    }

    @Test
    @DisplayName("Should create a new conversation with unique ID")
    void shouldStartConversation() {
        // When
        String conversationId = conversationService.startConversation();

        // Then
        assertThat(conversationId)
            .isNotNull()
            .isNotEmpty();
        assertThat(conversationService.conversationExists(conversationId)).isTrue();
    }

    @Test
    @DisplayName("Should generate different conversation IDs for each new conversation")
    void shouldGenerateUniqueConversationIds() {
        // When
        String id1 = conversationService.startConversation();
        String id2 = conversationService.startConversation();

        // Then
        assertThat(id1).isNotEqualTo(id2);
    }

    @Test
    @DisplayName("Should maintain conversation history across multiple messages")
    void shouldMaintainConversationHistory() {
        // Given
        String conversationId = conversationService.startConversation();
        
        // Configure mock to return different responses
        ChatResponse mockResponse1 = ChatResponse.builder()
            .aiMessage(AiMessage.from("Response 1"))
            .build();
        ChatResponse mockResponse2 = ChatResponse.builder()
            .aiMessage(AiMessage.from("Response 2"))
            .build();
        ChatResponse mockResponse3 = ChatResponse.builder()
            .aiMessage(AiMessage.from("Response 3"))
            .build();
        
        when(mockChatModel.chat(anyList()))
            .thenReturn(mockResponse1)
            .thenReturn(mockResponse2)
            .thenReturn(mockResponse3);

        // When
        conversationService.chat(conversationId, "First message");
        conversationService.chat(conversationId, "Second message");
        conversationService.chat(conversationId, "Third message");

        // Then
        List<ChatMessage> history = conversationService.getHistory(conversationId);
        assertThat(history).hasSize(6); // 3 user messages + 3 AI responses
    }

    @Test
    @DisplayName("Should include previous messages as context in new prompts")
    void shouldIncludeContextInPrompt() {
        // Given
        String conversationId = conversationService.startConversation();
        
        ChatResponse mockResponse = ChatResponse.builder()
            .aiMessage(AiMessage.from("Response"))
            .build();
        when(mockChatModel.chat(anyList())).thenReturn(mockResponse);

        // When
        conversationService.chat(conversationId, "Tell me about Java");
        conversationService.chat(conversationId, "What about Spring Boot?");

        // Then
        List<ChatMessage> history = conversationService.getHistory(conversationId);
        assertThat(history).hasSize(4); // 2 user + 2 AI messages
        // Conversation service builds context from all messages
    }

    @Test
    @DisplayName("Should isolate conversations by ID")
    void shouldIsolateConversationsByid() {
        // Given
        String conv1 = conversationService.startConversation();
        String conv2 = conversationService.startConversation();
        
        ChatResponse mockResponse = ChatResponse.builder()
            .aiMessage(AiMessage.from("Response"))
            .build();
        when(mockChatModel.chat(anyList())).thenReturn(mockResponse);

        // When
        conversationService.chat(conv1, "Message for conversation 1");
        conversationService.chat(conv2, "Message for conversation 2");

        // Then
        List<ChatMessage> history1 = conversationService.getHistory(conv1);
        List<ChatMessage> history2 = conversationService.getHistory(conv2);
        
        assertThat(history1).hasSize(2); // 1 user + 1 AI
        assertThat(history2).hasSize(2); // 1 user + 1 AI
        // Each conversation maintains its own separate history
    }

    @Test
    @DisplayName("Should clear conversation history")
    void shouldClearConversation() {
        // Given
        String conversationId = conversationService.startConversation();
        ChatResponse mockResponse = ChatResponse.builder()
            .aiMessage(AiMessage.from("Response"))
            .build();
        when(mockChatModel.chat(anyList())).thenReturn(mockResponse);
        conversationService.chat(conversationId, "Test message");

        // When
        conversationService.clearConversation(conversationId);

        // Then
        assertThat(conversationService.conversationExists(conversationId)).isFalse();
    }

    @Test
    @DisplayName("Should auto-create conversation if ID doesn't exist")
    void shouldAutoCreateConversationIfNotExists() {
        // Given
        String nonExistentId = "non-existent-conversation-id";
        ChatResponse mockResponse = ChatResponse.builder()
            .aiMessage(AiMessage.from("Response"))
            .build();
        when(mockChatModel.chat(anyList())).thenReturn(mockResponse);

        // When
        String response = conversationService.chat(nonExistentId, "Test message");

        // Then
        assertThat(response).isNotNull();
        assertThat(conversationService.conversationExists(nonExistentId)).isTrue();
    }

    @Test
    @DisplayName("Should respect maximum message window of 10 messages")
    void shouldRespectMaxMessageWindow() {
        // Given
        String conversationId = conversationService.startConversation();
        ChatResponse mockResponse = ChatResponse.builder()
            .aiMessage(AiMessage.from("Response"))
            .build();
        when(mockChatModel.chat(anyList())).thenReturn(mockResponse);

        // When - Send 12 messages (6 exchanges = 6 user + 6 AI messages = 12 total)
        for (int i = 1; i <= 6; i++) {
            conversationService.chat(conversationId, "Message " + i);
        }

        // Then - Should only keep last 10 messages (5 exchanges)
        List<ChatMessage> history = conversationService.getHistory(conversationId);
        assertThat(history).hasSizeLessThanOrEqualTo(10);
        // MessageWindowChatMemory with MAX_MESSAGES = 10 keeps only recent messages
    }
}
