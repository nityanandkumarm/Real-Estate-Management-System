package com.nitya.rest.users.entity;

import java.util.ArrayList;
import java.util.List;

public class WishlistData {

	private Integer id;

	private Integer userId;

	private List<Integer> propertyIds = new ArrayList<Integer>();

	public WishlistData() {
	}

	public WishlistData(Integer userId) {
		super();
		this.userId = userId;
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
