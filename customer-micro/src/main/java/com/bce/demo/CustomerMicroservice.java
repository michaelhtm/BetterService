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
			customerRepo.save(new Customer(1, "Rapunzel"));
			customerRepo.save(new Customer(2, "Sierva"));
			customerRepo.save(new Customer(3, "Yona"));
			for (Customer c : customerRepo.findAll()) {
				log.info(c.toString());
			}
		};
	}

	//@Autowired
	//GreetingService srvc;

	// keep this here for reference, but disconnect it from spring
	//@Bean
// 	public CommandLineRunner demo(GreetingRepository repository) {
// 		return (args) -> {

// 			// check new service works before by adding a record to see if it comes up
// 			Greeting g1 = new Greeting();
// 			long lid = 12;
// 			g1.setSid(lid);
// 			g1.setContent("Happy");
// 			srvc.saveGreeting(g1);

// 			// save a few customers
// 			lid = 1;
// 			repository.save(new Greeting(lid, "Bauer"));

// 			// fetch all customers
// 			log.info("Customers found with findAll():");
// 			log.info("-------------------------------");
// 			for (Greeting greeting : repository.findAll()) {
// 				log.info(greeting.toString());
// 			}
// 			log.info("");

// 			// fetch an individual customer by ID
// 			Optional<Greeting> greeting = repository.findById(1L);
// 			log.info("Customer found with findById(1L):");
// 			log.info("--------------------------------");
// 			log.info(greeting.toString());
// 			log.info("");

// 		};
// 	}
}
