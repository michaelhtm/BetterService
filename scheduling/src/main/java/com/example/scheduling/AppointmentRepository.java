package com.example.scheduling;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

	List<Appointment> findByCustomerId(String customerId);

	Appointment findById(long id);
}
