package com.pluq.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
@EnableMongoRepositories
@RestController
public class TechnicalExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnicalExerciseApplication.class, args);
	}

}
