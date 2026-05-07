package com.backend.embedding_service.dto;
import lombok.Data;

@Data
public class searchRequest {
    private String query;
    private int topK = 5;
}
