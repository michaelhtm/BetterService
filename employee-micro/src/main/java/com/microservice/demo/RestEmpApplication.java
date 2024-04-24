package com.microservice.demo;

import java.util.Collections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class RestEmpApplication {
	private static final Logger log = LoggerFactory.getLogger(RestEmpApplication.class);


	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(RestEmpApplication.class);
		// Change port in code (Editiing application.properties did nothing)
		// https://www.baeldung.com/spring-boot-change-port
		app.setDefaultProperties(Collections.singletonMap("server.port", "8884"));
		app.run(args);

	}

	@Bean
	public CommandLineRunner init(RestEmpRepositpry repo) {
		return (args) -> {
			repo.save(new RestEmployee("Doc", "I give sick cuts"));
			repo.save(new RestEmployee("Brad", "I can do braids"));
			repo.save(new RestEmployee("Daisy", "Im good with fades"));
			for (RestEmployee emp : repo.findAll()){
				log.info(emp.toString());
			}
		};
	}
}

