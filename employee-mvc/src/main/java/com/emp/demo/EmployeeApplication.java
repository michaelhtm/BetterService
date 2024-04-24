package com.emp.demo;

import java.util.Collections;

import javax.websocket.ClientEndpointConfig.Builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;


@SpringBootApplication
public class EmployeeApplication {
public static final Logger log = LoggerFactory.getLogger(EmployeeApplication.class);
	  
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(EmployeeApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8882"));
		app.run(args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner demo(EmployeeService repo) {
	return (args) -> {
		repo.saveEmployee(new Employee("Doc", "I give sick cuts"));
		repo.saveEmployee(new Employee("Brad", "I can do braids"));
		repo.saveEmployee(new Employee("Daisy", "Im good with fades"));
	};
}
}
