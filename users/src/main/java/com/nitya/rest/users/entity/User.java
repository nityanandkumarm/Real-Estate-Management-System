package com.nitya.rest.users.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity(name = "user_table")
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 2, message = "Size of name should be minimum 2")
	private String username;
	
	private String password;

	@CreationTimestamp
	private LocalDateTime registeredOn;

	private String role;

	public User() {

	}
	
	public User(@Size(min = 2, message = "Size of name should be minimum 2") String username, String password,
			String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Integer getId() {
		return id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", registeredOn=" + registeredOn
				+ ", role=" + role + "]";
	}
	
	
	
}
