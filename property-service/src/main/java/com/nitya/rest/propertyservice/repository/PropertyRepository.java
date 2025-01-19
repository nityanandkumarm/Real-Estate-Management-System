package com.nitya.rest.propertyservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nitya.rest.propertyservice.entity.Property;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer>{

	void deleteByProvider(String provider);

	List<Property> findAllByProvider(String provider);

	void deleteAllByProvider(String provider);

}
