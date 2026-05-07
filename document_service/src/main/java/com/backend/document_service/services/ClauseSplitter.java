package com.backend.document_service.services;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClauseSplitter {
    public List<String> splitIntoClauses(String text) {
        if (text == null || text.trim().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        // Split by newlines, clean up empty ones
        return Arrays.stream(text.split("\\n\\n+|\\r\\n\\r\\n+"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }
}
