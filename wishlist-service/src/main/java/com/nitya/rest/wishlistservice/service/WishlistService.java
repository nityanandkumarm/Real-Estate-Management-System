package com.nitya.rest.wishlistservice.service;

import java.util.List;

public interface WishlistService {
	
	public List<Integer> getWishlistById(Integer userId);
	
	public void addItemToWishlist(Integer userId, Integer propertyList);
	
	public void deleteItemFromWishlist(Integer userId, Integer propertyId);
	
	public void deleteWishlistById(Integer userId);
}
