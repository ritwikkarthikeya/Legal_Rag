package com.backend.document_service.model;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String filename;
    @Column(columnDefinition = "TEXT")
    private String content;
    
    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
    private List<Clause> clauses;
}
