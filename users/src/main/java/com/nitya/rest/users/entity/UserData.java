package com.nitya.rest.users.entity;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserData {

	private Integer id;

	@NotEmpty
	@Size(min = 2, message = "Size of name should be minimum 2")
	private String username;
	
	@NotNull
	private String password;

	private LocalDateTime registeredOn;

	private String role;

	public UserData() {

	}
	
	public UserData(Integer id, @Size(min = 2, message = "Size of name should be minimum 2") String username, String password,
			LocalDateTime registeredOn, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.registeredOn = registeredOn;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}
	

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getRegisteredOn() {
		return registeredOn;
	}

	public void setRegisteredOn(LocalDateTime registeredOn) {
		this.registeredOn = registeredOn;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserData [id=" + id + ", username=" + username + ", password=" + password + ", registeredOn="
				+ registeredOn + ", role=" + role + "]";
	}
	
	
}
