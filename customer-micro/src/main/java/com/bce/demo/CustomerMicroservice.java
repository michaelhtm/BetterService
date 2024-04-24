package com.bce.demo;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerMicroservice {
	private static final Logger log = LoggerFactory.getLogger(CustomerMicroservice.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(CustomerMicroservice.class);
		// Change port in code (Editiing application.properties did nothing)
		// https://www.baeldung.com/spring-boot-change-port
		app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
		app.run(args);
		//SpringApplication.run(CustomerMicroservice.class, args);
	}

	@Bean
	public CommandLineRunner init(CustomerRepository customerRepo) {
		return (args) -> {
			// initialize with default customers
			customerRepo.save(new Customer(1, "Rapunzel"));
			customerRepo.save(new Customer(2, "Sierva"));
			customerRepo.save(new Customer(3, "Yona"));
			for (Customer c : customerRepo.findAll()) {
				log.info(c.toString());
			}
		};
	}
}
