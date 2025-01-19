package com.nitya.rest.users.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitya.rest.users.entity.User;

import jakarta.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String username);

}
