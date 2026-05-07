package com.backend.document_service.services;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.stereotype.Service;
import java.io.InputStream;

@Service
public class documentParser {
    public String extractText(InputStream inputStream) {
        try {
            AutoDetectParser parser = new AutoDetectParser();
            BodyContentHandler handler = new BodyContentHandler(-1);
            Metadata metadata = new Metadata();
            parser.parse(inputStream, handler, metadata, new ParseContext());
            return handler.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error parsing document", e);
        }
    }
}
