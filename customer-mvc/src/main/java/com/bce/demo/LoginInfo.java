package com.bce.demo;

public class LoginInfo {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "**** login info: "+name;
	}
}
