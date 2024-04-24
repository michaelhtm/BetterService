package com.emp.demo;
//https://www.codejava.net/frameworks/spring/understand-spring-data-jpa-with-simple-example
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
 
@Service("employeeService")
public class EmployeeService {

    @Autowired
    RestTemplate restTemplate;

    String microUrl = "http://localhost:8884";


    public String saveEmployee(Employee newEmployee) {
        try{
            return restTemplate.postForObject(
            microUrl+"/saveEmployee", newEmployee, String.class);
        }catch(Exception e){
            return null;   
        }
    }

    public Employee getEmployeeByName(String name) {
        try{
            return restTemplate.getForObject(
            microUrl+"/getEmployee?name="+name, Employee.class);
        }catch (Exception e) {
            return null;
        }
       // return empository.findById(name).orElse(null);
    }

    // public Boolean noNoCustomer(String name){
    //     try{
    //         return restTemplate.getForObject(microUrl+"/noNoCustomer", Boolean.class);
    //     }catch (Exception e) {
    //         return null;
    //     }
    // }

}
