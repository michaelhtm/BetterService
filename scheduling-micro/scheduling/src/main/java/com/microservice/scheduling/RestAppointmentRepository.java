package com.microservice.scheduling;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RestAppointmentRepository extends CrudRepository<RestAppointment, Long> {

	List<RestAppointment> findByCustomerId(String customerId);
}
