package com.nitya.rest.wishlistservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitya.rest.wishlistservice.entity.Wishlist;

import jakarta.transaction.Transactional;

@Transactional
public interface WishlistRepository extends JpaRepository<Wishlist, Integer>{

	Optional<Wishlist> findByUserId(Integer userId);

	void deleteByUserId(Integer userId);

}
