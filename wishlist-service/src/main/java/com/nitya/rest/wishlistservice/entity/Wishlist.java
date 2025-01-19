package com.nitya.rest.wishlistservice.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Wishlist {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer userId;
	
	private List<Integer> propertyIds = new ArrayList<Integer>();
	
	public Wishlist() {}
	
	public Wishlist(Integer userId, List<Integer> propertyIds) {
		super();
		this.userId = userId;
		this.propertyIds = propertyIds;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<Integer> getPropertyIds() {
		return propertyIds;
	}

	public void addPropertyId(Integer propertyId) {
		this.propertyIds.add(propertyId);
	}
	
	public void removePropertyId(Integer propertyId) {
		this.propertyIds.remove(propertyId);
	}

	@Override
	public String toString() {
		return "Wishlist [id=" + id + ", userId=" + userId + ", propertyIds=" + propertyIds + "]";
	}

}
