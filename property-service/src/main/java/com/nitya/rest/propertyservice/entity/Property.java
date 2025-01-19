package com.nitya.rest.propertyservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Property {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String title;
	private String address;
	private String description;
	private String provider;
	
	public Property() {
		
	}
	
	public Property(String title, String address, String description, String provider) {
		super();
		this.title = title;
		this.address = address;
		this.description = description;
		this.provider= provider;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", title=" + title + ", address=" + address + ", description=" + description
				+ ", provider=" + provider + "]";
	}

}
