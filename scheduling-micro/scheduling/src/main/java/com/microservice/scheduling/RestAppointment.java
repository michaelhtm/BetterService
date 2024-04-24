package com.microservice.scheduling;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.annotation.processing.Generated;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
public class RestAppointment {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String customerId;
    private String employeeName;
    private LocalDate date;
    private LocalTime time;

    public RestAppointment() {}

    public RestAppointment(String cid, String ename, LocalDate d, LocalTime t) {
        customerId = cid;
        employeeName = ename;
        date = d;
        time = t;
    }

    @Override
	public String toString() {
		return String.format(
				"RestAppointment[id=%d, customerId='%s', employeeName='%s', date='%s', time='%s']",
				id, customerId, employeeName, date, time);
	}
}
