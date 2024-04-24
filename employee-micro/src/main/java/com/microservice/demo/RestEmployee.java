package com.microservice.demo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RestEmployee {

	@Id
	private String name;
	private String bio;
	private String nonoCustomer;

	protected RestEmployee() {}

	public RestEmployee(String name, String content) {
	    this.name = name;
	    this.bio = content;
	}
	  
	@Override
	public String toString() {
		return String.format(
				"Employee Name %s, Bio: %s",
				name, bio);
	}

	public String getName() {
		return name;
	}

	public String getBio(){
		return bio;
	}

	public String getNonoCustomer() {
		return nonoCustomer;
	}

	public void setName(String name){
		this.name = name;
	}

}
