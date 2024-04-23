package com.mvc.scheduling;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@Controller
public class SchedulingController {

	@Autowired
	AppointmentService service;

	private String error = "error";

	@GetMapping("/scheduling")
	public String schedulingForm(Model model) {
		model.addAttribute("appointment", new Appointment());
		return "scheduling";
	}

	@PostMapping("/scheduling")
	public String schedulingSubmit(@ModelAttribute Appointment appointment, Model model) {
		model.addAttribute("appointment", appointment);
		String saveResult = service.saveAppointment(appointment);
		if (saveResult == null) return error;
		else if (saveResult.equals("Yes")) return "result";
		return "redirect:/scheduling";
	}

	@GetMapping("/getAppointments")
	public String viewAppointmentsForm(Model model) {
		return "getAppointments";
	}

	@PostMapping("/getAppointments")
	public String viewAppointments(@RequestParam String customerId, Model model) {
		List<Appointment> appointments = service.getAppointmentsForCustomer(customerId);
		if (appointments == null) {
			return error;
		}
		model.addAttribute("customerId", customerId);
		model.addAttribute("appointments", appointments);
		return "viewAppointments";
	}

	@GetMapping("/editAppointment")
	public String editAppointmentForm(@RequestParam String id, Model model) {

		Appointment appointment = service.getAppointment(id);
		if (appointment == null) {
			return error;
		}
		model.addAttribute(appointment);
		return "editAppointmentForm";
	}

	@PostMapping("/editAppointment")
	public String editSubmit(Appointment appointment, Model model) {
		model.addAttribute(appointment);
		SchedulingApplication.log.info("This edited thingy ID "+appointment.getId());
		String saveResult = service.saveAppointment(appointment);
		if (saveResult == null) return error;
		else if(saveResult.equals("Yes")) return "result";
		return "redirect:/editAppointment";
	}
}