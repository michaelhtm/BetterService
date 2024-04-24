package com.microservice.scheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.mapping.List;
import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class RestSchedulingApplication {

	public static final Logger log = LoggerFactory.getLogger(RestSchedulingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestSchedulingApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
