package com.bce.demo;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CustomerRestController {
  // @Autowired
  // GreetingService srvc;
  @Autowired
  CustomerRepository customerRepo;

  /*
   * get customer by supplying id or name as parameter
   * /customers?id=1
   * /customers?name=John+Cena
   */
  @GetMapping("/customers")
  public CustomerRecord getCustomer(
      @RequestParam(defaultValue = "-1") int id,
      @RequestParam(defaultValue = "NONE") String name) {
    if (id != -1) {
      if (customerRepo.existsById(id)) {
        Customer cust = customerRepo.findById(id).get();
        return new CustomerRecord(id, cust.getName());
      }
    } else if (name != "NULL") {
      if (customerRepo.existsByName(name)) {
        Customer cust = customerRepo.findByName(name);
        return new CustomerRecord(cust.getId(), name);
      }
    }

    // fail
    return new CustomerRecord(-1, "NONE");
  }

  @PostMapping("/add")
  public void addCustomer(@RequestParam int id, @RequestParam String name) {
			customerRepo.save(new Customer(id, name));
  }

  @PostMapping("/change-name")
  public void changeName(@RequestParam int id, @RequestParam String name) {
    if (customerRepo.existsById(id)) {
      // CrudRepository returns a ***COPY*** of the requested object. Changes are made by clobbering the original (by @Id member, I assume)
      // Also the copy is wrapped in an Optional<> in the case of findById. .get gets the value
      Customer cust = customerRepo.findById(id).get();
      cust.setName(name);
      customerRepo.save(cust);
    }
  }
}
