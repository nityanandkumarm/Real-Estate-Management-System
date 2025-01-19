package com.nitya.rest.wishlistservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nitya.rest.wishlistservice.service.WishlistServiceImpl;

@RestController
public class WishlistController {

	@Autowired
	private WishlistServiceImpl wishlistServiceimpl;

	@GetMapping(path = "/wishlist/{userId}")
	public List<Integer> getUserWishlist(@PathVariable Integer userId) {
		return wishlistServiceimpl.getWishlistById(userId);
	}
	
	@DeleteMapping(path = "/wishlist/all/{userId}")
	public void deleteWishlist(@PathVariable Integer userId) {
		wishlistServiceimpl.deleteWishlistById(userId);
	}
	
	@DeleteMapping(path = "/wishlist/{userId}")
	public void deleteFromWishlist(@PathVariable Integer userId, @RequestBody Integer propertyId) {
		wishlistServiceimpl.deleteItemFromWishlist(userId, propertyId);
	}

	@PostMapping(path = "/wishlist/{userId}")
	public void addToWishlist(@PathVariable Integer userId, @RequestBody Integer propertyId) {
		wishlistServiceimpl.addItemToWishlist(userId, propertyId);
	}
	
	
}
