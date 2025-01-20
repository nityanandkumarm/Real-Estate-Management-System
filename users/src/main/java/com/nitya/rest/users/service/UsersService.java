package com.nitya.rest.users.service;

import java.util.List;

import com.nitya.rest.users.entity.User;
import org.springframework.http.ResponseEntity;

import com.nitya.rest.users.entity.UserData;


public interface UsersService {
	
	public List<UserData> findAllUserDetails();
	
	public UserData findUserDetailsById(Integer id);
	
	public void deleteUserDetailsById(Integer id);
	
	public ResponseEntity<User> registerUser(UserData user);
}
