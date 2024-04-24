package com.emp.demo;



public class Employee {

	private String name;
	private String bio;

	protected Employee() {}

	public Employee(String name, String content) {
	    this.name = name;
	    this.bio = content;
	}
	  
	@Override
	public String toString() {
		return String.format(
	        "Employee[Name=%s,content='%s']",
	        name, bio);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String content) {
		this.bio = content;
	}

}
