package com.restfull.fullstackbackend.dto;

public class HelloWorldBean {

	private String message;
	public HelloWorldBean(String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
	

}
