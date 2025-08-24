package com.guru.content_calendar.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Table("content")
public record Content(
        @Id
        Integer id,

        @NotBlank
        String title,

        String description,
        Status status,

        @Column("content_type")
        Type contentType,

        @Column("date_created")
        LocalDateTime dateCreated,

        @Column("date_updated")
        LocalDateTime dateUpdated,

        String url
) {}