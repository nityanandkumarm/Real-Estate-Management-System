package com.nitya.rest.wishlistservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitya.rest.wishlistservice.entity.Wishlist;
import com.nitya.rest.wishlistservice.exception.WishlistNotFoundException;
import com.nitya.rest.wishlistservice.repository.WishlistRepository;

@Service
public class WishlistServiceImpl implements WishlistService{

	@Autowired
	private WishlistRepository wishlistRepo;
	
	@Override
	public List<Integer> getWishlistById(Integer userId) {
		
		Optional<Wishlist> userWishlist = wishlistRepo.findByUserId(userId);
		
		if(userWishlist.isEmpty()){
			throw new WishlistNotFoundException(""+userId);
		}
		
		return userWishlist.get().getPropertyIds();
	}

	@Override
	public void addItemToWishlist(Integer userId, Integer propertyId){
		
		Optional<Wishlist> userWishlist= wishlistRepo.findByUserId(userId);
		
		if(userWishlist.isEmpty()){
			List<Integer> propertyIds = new ArrayList<>();
			propertyIds.add(propertyId);
			Wishlist newWishlist = new Wishlist(userId, propertyIds);
			wishlistRepo.save(newWishlist);
		}
		else {
			userWishlist.get().addPropertyId(propertyId);
			wishlistRepo.save(userWishlist.get());
		}
	}

	@Override
	public void deleteItemFromWishlist(Integer userId, Integer propertyId) {
		
		Optional<Wishlist> userWishlist= wishlistRepo.findByUserId(userId);
		
		if(userWishlist.isEmpty()){
			throw new WishlistNotFoundException(""+userId);
		}
		
		userWishlist.get().removePropertyId(propertyId);
		wishlistRepo.save(userWishlist.get());
	}

	public void deleteWishlistById(Integer userId) {
		wishlistRepo.deleteByUserId(userId);
	}

}
