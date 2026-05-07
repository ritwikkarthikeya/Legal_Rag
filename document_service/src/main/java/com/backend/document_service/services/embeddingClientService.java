package com.backend.document_service.services;
import com.backend.document_service.dto.embeddingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class embeddingClientService {
    private final WebClient webClient;

    public void sendClause(Long clauseId, String text) {
        embeddingRequest request = new embeddingRequest(clauseId, text);
        webClient.post()
                .uri("/api/embeddings")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Void.class)
                .subscribe(); // Fire and forget for now
    }
}
