package com.example.scheduling;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCustomerId(String cId) {
		customerId = cId;
	}

	public void setEmployeeId(String eId) {
		employeeId = eId;
	}

	public void setDate(String d) {
		this.date = d;
	}

	public void setTime(String t) {
		this.time = t;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
