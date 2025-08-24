package com.guru.content_calendar.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guru.content_calendar.model.Content;
import com.guru.content_calendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final ContentRepository repository;
    private final ObjectMapper objectMapper;

    public DataLoader(ContentRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if(repository.count() == 0) {
            String resourcePath = "/data/content.json";
            try (InputStream inputStream = getClass().getResourceAsStream(resourcePath)) {
                if (inputStream == null) {
                    System.err.println("Could not find resource: " + resourcePath);
                    return;
                }

                List<Content> contents = objectMapper.readValue(inputStream, new TypeReference<List<Content>>(){});
                repository.saveAll(contents);
                System.out.println("Loaded " + contents.size() + " content items from JSON");
            }
        } else {
            System.out.println("Content table already has data, skipping data loading");
        }
    }
}