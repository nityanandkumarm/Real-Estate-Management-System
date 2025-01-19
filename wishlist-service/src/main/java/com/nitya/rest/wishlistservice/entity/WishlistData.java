package com.nitya.rest.wishlistservice.entity;

import java.util.ArrayList;
import java.util.List;

public class WishlistData {

	private Integer id;

	private Integer userId;

	private List<Integer> propertyIds = new ArrayList<Integer>();

	public WishlistData() {
	}

	public WishlistData(Integer id, Integer userId, List<Integer> propertyIds) {
		super();
		this.id = id;
		this.userId = userId;
		this.propertyIds = propertyIds;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPropertyIds(List<Integer> propertyIds) {
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
