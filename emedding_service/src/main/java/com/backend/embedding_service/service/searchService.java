package com.backend.embedding_service.service;
import com.backend.embedding_service.dto.searchRequest;
import com.backend.embedding_service.model.clauseEmbedding;
import com.backend.embedding_service.repository.clauseEmbeddingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class searchService {
    private final clauseEmbeddingRepository repository;
    private final EmbeddingServiceGenerator generator;

    public List<clauseEmbedding> searchSimilar(searchRequest request) {
        float[] queryVector = generator.generateEmbedding(request.getQuery());
        // Convert array to string format for pgvector query
        StringBuilder vectorStr = new StringBuilder("[");
        for (int i = 0; i < queryVector.length; i++) {
            vectorStr.append(queryVector[i]);
            if (i < queryVector.length - 1) vectorStr.append(",");
        }
        vectorStr.append("]");
        
        return repository.findSimilarClauses(vectorStr.toString(), request.getTopK());
    }
}
