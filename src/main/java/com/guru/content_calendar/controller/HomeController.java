package com.guru.content_calendar.controller;

import com.guru.content_calendar.config.ContentCalenderProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {

    private final ContentCalenderProperties properties;

    public HomeController(ContentCalenderProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/")
    public ContentCalenderProperties home () {
        return properties;
    }
}
