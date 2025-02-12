package com.nitya.rest.users.controller;

import java.util.List;

import com.nitya.rest.users.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nitya.rest.users.entity.PropertyData;
import com.nitya.rest.users.entity.UserData;
import com.nitya.rest.users.proxy.PropertyServiceProxy;
import com.nitya.rest.users.proxy.WishlistServiceProxy;
import com.nitya.rest.users.service.UsersServiceImpl;

import jakarta.validation.Valid;

@RestController
public class UsersController {

	private final UsersServiceImpl usersServiceImpl;

	private final WishlistServiceProxy wishlistProxy;

	private final PropertyServiceProxy propertyProxy;

	@Autowired
	UsersController(UsersServiceImpl usersServiceImpl, WishlistServiceProxy wishlistProxy, PropertyServiceProxy propertyProxy){
		this.wishlistProxy = wishlistProxy;
		this.propertyProxy = propertyProxy;
		this.usersServiceImpl = usersServiceImpl;
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping(path = "/users")
	public List<UserData> getAllUserDetails() {
		return usersServiceImpl.findAllUserDetails();
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@GetMapping(path = "/users/{id}")
	public UserData getUserDetails(@PathVariable Integer id) {
		return usersServiceImpl.findUserDetailsById(id);
	}

	
	@PostMapping(path = "/register")
	public ResponseEntity<User> registerNewUser(@Valid @RequestBody UserData userData) {
		return usersServiceImpl.registerUser(userData);
	}

	/**
	 * Dependency on wishlist-service indirectly
	 * @param id
	 */
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@DeleteMapping(path = "/users/{id}")
	public void deRegisterUser(@PathVariable Integer id) {
		usersServiceImpl.deleteUserDetailsById(id);
	}

	/**
	 * Dependency on wishlist-service directly
	 * @param id
	 * @return List<Integer>
	 */
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping(path = "/users/{id}/wishlist")
	public List<Integer> getWishlist(@PathVariable Integer id) {
		return wishlistProxy.getUserWishlist(id);
	}
	
	@PostMapping(path = "users/{id}/wishlist")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public void addItemsToWishlist(@PathVariable Integer id, @RequestBody Integer propertyId) {
		wishlistProxy.addToWishlist(id, propertyId);
	}
	
	@DeleteMapping(path = "users/{id}/wishlist")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public void deleteItemsFromWishlist(@PathVariable Integer id, @RequestBody Integer propertyId) {
		wishlistProxy.deleteFromWishlist(id, propertyId);
	}

	/**
	 * Dependency on property-service
	 * @return List<PropertyData>
	 */
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@GetMapping(path = "/properties")
	public List<PropertyData> getAllPropertyDetails() {
		return propertyProxy.getAllPropertyDetails();
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@GetMapping(path = "/properties/{provider}")
	public List<PropertyData> getAllPropertyDetailsByProvider(@PathVariable String provider) {
		return propertyProxy.getPropertiesByProvider(provider);
	}
	
	@PostMapping(path = "/properties/{provider}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<PropertyData> addPropertyDetails(@PathVariable String provider, @Valid @RequestBody PropertyData property) {
		return propertyProxy.addProperty(provider, property);
	}

	@DeleteMapping(path = "/properties/{provider}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public void deleteAllPropertyDetailsByProvider(@PathVariable String provider) {
		propertyProxy.deleteAllPropertiesByProvider(provider);
	}


}
