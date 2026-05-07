package com.backend.embedding_service.controller;
import com.backend.embedding_service.dto.embeddingRequest;
import com.backend.embedding_service.service.clauseEmbeddingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/embeddings")
@RequiredArgsConstructor
public class embeddingController {
    private final clauseEmbeddingService embeddingService;

    @PostMapping
    public ResponseEntity<Void> receiveClause(@RequestBody embeddingRequest request) {
        embeddingService.processAndSaveEmbedding(request);
        return ResponseEntity.ok().build();
    }
}
