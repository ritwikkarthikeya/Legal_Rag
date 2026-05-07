package com.backend.document_service.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class embeddingRequest {
    private Long clauseId;
    private String text;
}
