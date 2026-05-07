package com.backend.document_service.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Clause {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;
    
    @Column(columnDefinition = "TEXT")
    private String text;
    private Integer clauseIndex;
}
