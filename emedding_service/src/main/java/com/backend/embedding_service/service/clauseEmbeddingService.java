package com.backend.embedding_service.service;
import com.backend.embedding_service.dto.embeddingRequest;
import com.backend.embedding_service.model.clauseEmbedding;
import com.backend.embedding_service.repository.clauseEmbeddingRepository;
import com.pgvector.PGvector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class clauseEmbeddingService {
    private final clauseEmbeddingRepository repository;
    private final EmbeddingServiceGenerator generator;

    public void processAndSaveEmbedding(embeddingRequest request) {
        float[] vector = generator.generateEmbedding(request.getText());
        
        clauseEmbedding embedding = new clauseEmbedding();
        embedding.setClauseId(request.getClauseId());
        embedding.setText(request.getText());
        embedding.setEmbedding(new PGvector(vector));
        
        repository.save(embedding);
    }
}
