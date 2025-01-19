package com.nitya.rest.users.entity;

public class PropertyData {

	private Integer id;
	private String title;
	private String address;
	private String description;
	private String provider;

	public PropertyData() {

	}

	public PropertyData(Integer id, String title, String address, String description, String provider) {
		super();
		this.id = id;
		this.title = title;
		this.address = address;
		this.description = description;
		this.provider = provider;
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
		return "PropertyData [id=" + id + ", title=" + title + ", address=" + address + ", description=" + description
				+ ", provider=" + provider + "]";
	}

}
