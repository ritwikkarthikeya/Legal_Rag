package com.backend.document_service.services;
import com.backend.document_service.model.Clause;
import com.backend.document_service.model.Document;
import com.backend.document_service.repository.ClauseRepository;
import com.backend.document_service.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final ClauseRepository clauseRepository;
    private final documentParser parser;
    private final ClauseSplitter splitter;
    private final embeddingClientService embeddingClient;

    @Transactional
    public Document processDocument(String filename, InputStream inputStream) {
        String text = parser.extractText(inputStream);
        
        Document document = new Document();
        document.setFilename(filename);
        document.setContent(text);
        document.setClauses(new ArrayList<>());
        document = documentRepository.save(document);

        List<String> clauseTexts = splitter.splitIntoClauses(text);
        
        for (int i = 0; i < clauseTexts.size(); i++) {
            Clause clause = new Clause();
            clause.setDocument(document);
            clause.setText(clauseTexts.get(i));
            clause.setClauseIndex(i);
            clause = clauseRepository.save(clause);
            
            embeddingClient.sendClause(clause.getId(), clause.getText());
        }
        
        return document;
    }
}
