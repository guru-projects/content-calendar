package com.guru.content_calendar;

import com.guru.content_calendar.config.ContentCalenderProperties;
import com.guru.content_calendar.model.Content;
import com.guru.content_calendar.model.Status;
import com.guru.content_calendar.model.Type;
import com.guru.content_calendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
@EnableConfigurationProperties(ContentCalenderProperties.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
