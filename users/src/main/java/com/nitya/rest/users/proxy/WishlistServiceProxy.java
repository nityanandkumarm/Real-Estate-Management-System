package com.nitya.rest.users.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "wishlist-service", url = "localhost:8082")
@FeignClient(name = "wishlist-service")
public interface WishlistServiceProxy {
	
	@GetMapping(path = "/wishlist/{userId}")
	public List<Integer> getUserWishlist(@PathVariable Integer userId);
	
	@DeleteMapping(path = "/wishlist/all/{userId}")
	public void deleteWishlist(@PathVariable Integer userId);
	
	@DeleteMapping(path = "/wishlist/{userId}")
	public void deleteFromWishlist(@PathVariable Integer userId, @RequestBody Integer propertyId);

	@PostMapping(path = "/wishlist/{userId}")
	public void addToWishlist(@PathVariable Integer userId, @RequestBody Integer propertyId);
}
