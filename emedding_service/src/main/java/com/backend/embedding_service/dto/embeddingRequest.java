package com.backend.embedding_service.dto;
import lombok.Data;

@Data
public class embeddingRequest {
    private Long clauseId;
    private String text;
}
