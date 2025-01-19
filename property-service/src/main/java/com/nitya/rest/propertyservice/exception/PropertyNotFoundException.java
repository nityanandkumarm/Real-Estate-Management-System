package com.nitya.rest.propertyservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PropertyNotFoundException extends RuntimeException {
	public PropertyNotFoundException(String message) {
		super("No property found " + message);
	}
}
