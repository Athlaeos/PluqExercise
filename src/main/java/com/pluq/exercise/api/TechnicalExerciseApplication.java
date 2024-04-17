package com.pluq.exercise.api;

import com.pluq.exercise.domain.ChargeLocation;
import com.pluq.exercise.service.GsonChargeLocationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
@RestController
public class TechnicalExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnicalExerciseApplication.class, args);
	}

	@GetMapping("/test")
	public Collection<ChargeLocation> test() {
		return new GsonChargeLocationService().fetchLocations();
	}

}
