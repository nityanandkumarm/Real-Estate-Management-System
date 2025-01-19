package com.nitya.rest.wishlistservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class WishlistNotFoundException extends RuntimeException {
	public WishlistNotFoundException(String message) {
		super("Not found Wishlist for User id : " + message);
	}
}
