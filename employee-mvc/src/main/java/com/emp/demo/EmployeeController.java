package com.emp.demo;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@SessionAttributes("Id")
public class EmployeeController {

  @Autowired
  private EmployeeService srvc;
  
  @GetMapping("/initial")
  public String initial(Model model) {
      return "initial";
  }

  @PostMapping("/initial")
  public String postInitial(@RequestParam String employeeName, Model model) {
      Employee employee = srvc.getEmployeeByName(employeeName);
      if(employee == null) {
        return "redirect:/initial";
      }
      model.addAttribute("employee", employee);
      return "employee";
  }
  
  @GetMapping("/create")
  public String createEmployeeForm(Model model) {
      model.addAttribute(new Employee());
      return "create";
  }

  @PostMapping("/create")
  public String createEmployee(@ModelAttribute Employee employee, Model model) {
    if (srvc.saveEmployee(employee) == null) {
      return "errorPage";
    }
    return "employee";
  }




}