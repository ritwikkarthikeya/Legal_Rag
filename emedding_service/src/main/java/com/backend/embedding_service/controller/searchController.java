package com.backend.embedding_service.controller;
import com.backend.embedding_service.dto.searchRequest;
import com.backend.embedding_service.model.clauseEmbedding;
import com.backend.embedding_service.service.searchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class searchController {
    private final searchService searchSvc;

    @PostMapping
    public ResponseEntity<List<clauseEmbedding>> search(@RequestBody searchRequest request) {
        List<clauseEmbedding> results = searchSvc.searchSimilar(request);
        return ResponseEntity.ok(results);
    }
}
