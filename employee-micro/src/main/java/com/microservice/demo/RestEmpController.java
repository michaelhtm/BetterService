package com.microservice.demo;

//https://www.codejava.net/frameworks/spring/understand-spring-data-jpa-with-simple-example
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


 
@RestController
public class RestEmpController {

    @Autowired
    RestEmpRepositpry empository;

    // @Autowired
    // RestTemplate restTemplate;

    @GetMapping("/getEmployee")
    public RestEmployee getEmployee(@RequestParam(defaultValue = "NONE") String name){
        if (empository.existsByName(name)){
            return empository.findByName(name);
        }
        return null;
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@RequestBody RestEmployee employee) {
        try{
            empository.save(employee);
            return "Success";
        }catch(Exception e) {
            return "Error";
        }
    }

    /** microservice called by employee */
    @GetMapping("/employeeExists")
    public boolean employeeExists(@RequestParam String employeeName){
        return empository.existsByName(employeeName);
    }
    
    // /** microservice calling customer does customer exist*/
    // @GetMapping("/noNoCustomer")
    // public boolean findCustomer(@RequestParam String customerName){
    //     try{
    //       return restTemplate.getForObject("http://localhost:8083/customers?name=" + customerName, Boolean.class);
    //     }catch(Exception e){
    //       return false;
    //     }
    // }
}