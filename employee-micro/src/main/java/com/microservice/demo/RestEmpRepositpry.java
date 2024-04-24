package com.microservice.demo;

import org.springframework.data.repository.CrudRepository;

public interface RestEmpRepositpry extends 
	CrudRepository<RestEmployee, Long> {

		  RestEmployee findByName(String name);

		  boolean existsByName(String name);
}