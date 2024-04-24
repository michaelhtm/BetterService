package com.mvc.scheduling;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter
public class Appointment {

	private Long id;
	private String customerId;
	private String employeeName;
    private LocalDate date;
    private LocalTime time;

	protected Appointment() {}

	public Appointment(String cId, String eId, LocalDate d, LocalTime t) {
		this.customerId = cId;
		this.employeeName = eId;
        this.date = d;
        time = t;
	}

	@Override
	public String toString() {
		return String.format(
				"Appointment[id=%d, customerId='%s', employeeName='%s', date='%s', time='%s']",
				id, customerId, employeeName, date, time);
	}
}
