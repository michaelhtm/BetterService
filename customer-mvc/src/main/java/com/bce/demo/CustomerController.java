package com.bce.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class CustomerController {
  // @Autowired
  // GreetingService srvc;

  RestTemplate micro = new RestTemplate();
  String microUrl = "http://localhost:8081";
  // for handling responses
  ResponseEntity<String> response;
	ObjectMapper mapper = new ObjectMapper();
  JsonNode json;

}
