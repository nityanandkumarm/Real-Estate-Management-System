package com.nitya.rest.users.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	
	private LocalDateTime time;
	private String message;
	private String Details;
	
	public ErrorDetails(LocalDateTime localDateTime, String message, String details) {
		super();
		this.time = localDateTime;
		this.message = message;
		Details = details;
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
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}
	
}
