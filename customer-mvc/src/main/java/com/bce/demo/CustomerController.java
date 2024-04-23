package com.bce.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@SessionAttributes("id") // required for the model to remember id. Otherwise, model attributes have method scope
public class CustomerController {
  // @Autowired
  // GreetingService srvc;

  RestTemplate micro = new RestTemplate();
  String microUrl = "http://localhost:8083";
  String schedulingMicroUrl = "http://localhost:8081";
  // for handling responses
  ResponseEntity<String> response;
	ObjectMapper mapper = new ObjectMapper();
  JsonNode json;


  /*
   * Just an alternate way to get to /{id}/home
   * Might remove later
   */
  @GetMapping("/")
  public String login(Model model) {
    return "login";
  }

  /*
   * Might remove later
   */
  @PostMapping("/")
  public String postLogin(@RequestParam int enteredId, Model model) throws JsonMappingException, JsonProcessingException {
    response = micro.getForEntity(microUrl+"/customers?id="+enteredId,
     String.class);
    json = mapper.readTree(response.getBody());
    int foundId = json.path("id").asInt();
    if (foundId != -1) {
      model.addAttribute("id", foundId);
      return "redirect:/"+foundId+"/home";
    }
    else {
      return "login"; // silently fail
    }
  }

  @GetMapping("/{id}/home")
  public String getCustHome(@PathVariable int id, Model model) throws JsonMappingException, JsonProcessingException {
    // get the customer's name from {id} in the url path
    response = micro.getForEntity(microUrl+"/customers?id="+id, String.class);
    json = mapper.readTree(response.getBody());

    // if customer not found, kick to login page
    int foundId = json.path("id").asInt();
    if (foundId == -1) {
      model.addAttribute("id", foundId);
      return "redirect:/login";
    } else {
      String custName = json.path("name").asText();

      // this lets you refer to the String custName name using "${name}" in thymeleaf
      // html
      // model.addAttribute("id", new String(""+id));
      model.addAttribute("id", id);
      model.addAttribute("name", custName);
      return "home"; // serves home.html, or generally retval.html
    }
  }

  @PostMapping("/post-name")
  public String postName(@RequestParam String newName, Model model) {
    // "id" is a @SessionAttributes
    micro.postForEntity(microUrl+"/change-name?id="+model.getAttribute("id")+"&name="+newName,
     null, Object.class);

    return "redirect:"+model.getAttribute("id")+"/home";
  }

  @GetMapping("/{id}/appts")
  public String showAppts(@PathVariable int id, Model model) throws JsonMappingException, JsonProcessingException {
    //response = micro.getForEntity(schedulingMicroUrl+"?id="+id, String.class);
    // simulate using customer microservice for now
    response = micro.getForEntity(microUrl+"/sched/?id="+id, String.class);
    json = mapper.readTree(response.getBody());
    model.addAttribute("appts", json);
    return "appts";
  }
}