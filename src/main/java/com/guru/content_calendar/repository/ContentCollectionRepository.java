package com.guru.content_calendar.repository;

import com.guru.content_calendar.model.Content;
import com.guru.content_calendar.model.Status;
import com.guru.content_calendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll () {
        return contentList;
    }

    public Optional<Content> findById (Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    @PostConstruct
    public void init () {
        contentList.add(new Content(
                1,
                "My First Blog Post",
                "My First Blog Post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""));
    }

    public boolean existsById(Integer id) {  // Fixed method name
        return contentList.stream().anyMatch(c -> c.id().equals(id));
    }

    public void deleteById(Integer id) {  // Added proper deleteById method
        contentList.removeIf(c -> c.id().equals(id));
    }

    public void delete(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
    }
}