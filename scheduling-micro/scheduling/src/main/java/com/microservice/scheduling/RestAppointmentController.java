package com.microservice.scheduling;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;

@RestController
public class RestAppointmentController {

	@Autowired
	RestAppointmentRepository repository;

	@Autowired
	private RestTemplate restTemplate;

	private static final String MICROURL = "https://localhost:8884";

	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/viewAllAppointments")
	public List<RestAppointment> viewAllAppointments(@RequestParam(value = "customerId", defaultValue="-1") String customerId) {

		return repository.findByCustomerId(customerId);
	}

	@GetMapping("/getAppointment")
	public RestAppointment getAppointment(@RequestParam(value = "appointmentId", defaultValue="-1") String id) {

		Long appId = Long.parseLong(id);
		return repository.findById(appId).orElse(null);
	}

	@PostMapping("/saveAppointment")
	public String saveAppointment(@RequestBody RestAppointment appointment) {

		try{
			if(appointment.getId() == null)
				appointment.setId(counter.incrementAndGet());
			
			// Boolean employeeExists = restTemplate.getForObject(MICROURL+"employeeExists?employeeName="+appointment.getEmployeeId(), Boolean.class);
			// if (employeeExists)
				
			// else return "No";
			repository.save(appointment);
			return "Yes";
		}catch(Exception e){
			return "No";
		}
	}
}
