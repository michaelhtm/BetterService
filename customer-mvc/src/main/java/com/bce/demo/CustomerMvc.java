package com.bce.demo;

import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class CustomerMvc {
	private static final Logger log = LoggerFactory.getLogger(CustomerMvc.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(CustomerMvc.class);
		// Change port in code (Editiing application.properties did nothing)
		// https://www.baeldung.com/spring-boot-change-port
		app.setDefaultProperties(Collections.singletonMap("server.port", "8082"));
		app.run(args);
	}

	RestTemplate micro = new RestTemplate();
	String microUrl = "http://localhost:8083";
	// for mapping JSON
	// https://www.baeldung.com/rest-template
	ObjectMapper mapper = new ObjectMapper();

	// @Bean
	// public CommandLineRunner init() {
	// 	return (args) -> {
	// 		/* MICROSERVICE TESTS */

	// 		// reusable references
	// 		ResponseEntity<String> response;
	// 		JsonNode json;

	// 		// add a customer (simple test of POST to microservice)
	// 		// Object.class works, but String.class would be required if assigning to response declared above
	// 		micro.postForEntity(microUrl+"/add?id=4&name=New+customer", null, Object.class);

	// 		// 1-3 already exist
	// 		// 4 should give the new customer
	// 		// 5 should give JSON indicating not found
	// 		for (int i = 1; i <= 5; i++) {
	// 			response = micro.getForEntity(microUrl+"/customers?id="+i, String.class);
	// 			json = mapper.readTree(response.getBody());
	// 			log.info(json.path("name").asText());
	// 		}

	// 		// find by name
	// 		response = micro.getForEntity(microUrl+"/customers?name=New+customer", String.class);
	// 		json = mapper.readTree(response.getBody());
	// 		log.info(json.toString());

	// 		// change name
	// 		micro.postForEntity(microUrl+"/change-name?id=4&name=Renamed+customer", null, String.class);
	// 		// did it change?
	// 		//TimeUnit.SECONDS.sleep(1);
	// 		response = micro.getForEntity(microUrl + "/customers?id=4", String.class);
	// 		json = mapper.readTree(response.getBody());
	// 		log.info(json.toString());
	// 	};
	// }
}