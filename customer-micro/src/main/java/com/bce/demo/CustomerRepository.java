package com.bce.demo;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends
		CrudRepository<Customer, Integer> {
	// This is the original guide with github link:
	// https://spring.io/guides/gs/accessing-data-jpa
	// I'll want to use existsById(ID id)
	// https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html

	// An @Entity's ID is its @Id member

	// If you declare a new method like this, spring will generate an implementation based on the param names and types used:
	// List<Customer> findByLastName(String lastName);
	Customer findByName(String name);
    boolean existsByName(String name);
}