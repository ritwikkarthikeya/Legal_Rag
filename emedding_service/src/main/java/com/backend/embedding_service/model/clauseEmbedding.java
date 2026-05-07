package com.backend.embedding_service.model;
import com.pgvector.PGvector;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class clauseEmbedding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long clauseId;
    
    @Column(columnDefinition = "TEXT")
    private String text;
    
    @Column(columnDefinition = "vector(1536)")
    private PGvector embedding;
}
