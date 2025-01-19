package com.nitya.rest.propertyservice.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	
	private LocalDateTime time;
	private String message;
	private String details;
	
	public ErrorDetails(LocalDateTime localDateTime, String message, String details) {
		super();
		this.time = localDateTime;
		this.message = message;
		this.details = details;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
}
