package com.nitya.rest.users.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nitya.rest.users.entity.User;
import com.nitya.rest.users.entity.UserData;
import com.nitya.rest.users.exception.UserNotFoundException;
import com.nitya.rest.users.proxy.WishlistServiceProxy;
import com.nitya.rest.users.repository.UserRepository;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private WishlistServiceProxy wishlistProxy;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<UserData> findAllUserDetails() {
		List<User> userList = userRepo.findAll();
		if (userList.isEmpty()) {
			throw new UserNotFoundException("Any ID");
		}
		List<UserData> userListData = new ArrayList<>();
		userList.stream().forEach(user -> {
			UserData userData = new UserData();
			BeanUtils.copyProperties(user, userData);
			userData.setPassword("#password-fetch-not-allowed");
			userListData.add(userData);
		});
		return userListData;
	}

	@Override
	public UserData findUserDetailsById(Integer id) {
		Optional<User> userDetails = userRepo.findById(id);

		if (userDetails.isEmpty()) {
			throw new UserNotFoundException("" + id);
		}
		UserData userData = new UserData();
		BeanUtils.copyProperties(userDetails.get(), userData);
		userData.setPassword("#password-fetch-not-allowed");
		return userData;
	}

	@Override
	public void deleteUserDetailsById(Integer id) {
		Optional<User> userDetails = userRepo.findById(id);

		if (userDetails.isEmpty()) {
			throw new UserNotFoundException("" + id);
		}
		wishlistProxy.deleteWishlist(userDetails.get().getId());
		userRepo.deleteById(id);
	}

	@Override
	public ResponseEntity<?> registerUser(UserData userData) {
		Optional<User> userDetails = userRepo.findByUsername(userData.getUsername());
		if (userDetails.isPresent()) {
			throw new ResponseStatusException(
			           HttpStatus.BAD_REQUEST, "username already exists, please use different username");
		}
		User user = new User();
		BeanUtils.copyProperties(userData, user);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		User savedUser = userRepo.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
