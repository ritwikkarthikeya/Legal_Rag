package com.backend.embedding_service.service;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class EmbeddingServiceGenerator {
    // Generate mock 1536-dimensional embedding (like OpenAI's text-embedding-ada-002)
    public float[] generateEmbedding(String text) {
        float[] embedding = new float[1536];
        Random random = new Random();
        for (int i = 0; i < embedding.length; i++) {
            embedding[i] = random.nextFloat();
        }
        return embedding;
    }
}
