package com.example.langchain4j.rag.service;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.openaiofficial.OpenAiOfficialEmbeddingModel;
import dev.langchain4j.model.output.Response;
import dev.langchain4j.store.embedding.EmbeddingStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for generating and managing embeddings.
 */
@Service
public class EmbeddingService {

    private static final Logger log = LoggerFactory.getLogger(EmbeddingService.class);

    private final OpenAiOfficialEmbeddingModel embeddingModel;
    private final EmbeddingStore<TextSegment> embeddingStore;

    public EmbeddingService(
            OpenAiOfficialEmbeddingModel embeddingModel,
            EmbeddingStore<TextSegment> embeddingStore) {
        this.embeddingModel = embeddingModel;
        this.embeddingStore = embeddingStore;
    }

    /**
     * Generate and store embeddings for text segments.
     *
     * @param segments list of text segments
     * @return number of embeddings created
     */
    public int storeSegments(List<TextSegment> segments) {
        log.info("Generating embeddings for {} segments", segments.size());
        
        try {
            // Generate embeddings for all segments
            Response<List<Embedding>> response = embeddingModel.embedAll(segments);
            List<Embedding> embeddings = response.content();
            
            // Store embeddings with their segments
            embeddingStore.addAll(embeddings, segments);
            
            log.info("Successfully stored {} embeddings", embeddings.size());
            return embeddings.size();
            
        } catch (Exception e) {
            log.error("Failed to store embeddings", e);
            throw new RuntimeException("Embedding storage failed: " + e.getMessage(), e);
        }
    }
}
