package com.example.scheduling;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SchedulingController {

	@GetMapping("/scheduling")
	public String schedulingForm(Model model) {
		model.addAttribute("appointment", new Appointment());
		return "scheduling";
	}

	@PostMapping("/scheduling")
	public String schedulingSubmit(@ModelAttribute Appointment appointment, Model model) {
		model.addAttribute("appointment", appointment);
		return "result";
	}

}