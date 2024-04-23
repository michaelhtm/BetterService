package com.mvc.scheduling;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Appointment {

	private Long id;
	private String customerId;
	private String employeeId;
    private String date;
    private String time;

	protected Appointment() {}

	public Appointment(String cId, String eId, String d, String t) {
		this.customerId = cId;
		this.employeeId = eId;
        this.date = d;
        time = t;
	}

	@Override
	public String toString() {
		return String.format(
				"Appointment[id=%d, customerId='%s', employeeId='%s', date='%s', time='%s']",
				id, customerId, employeeId, date, time);
	}
}
