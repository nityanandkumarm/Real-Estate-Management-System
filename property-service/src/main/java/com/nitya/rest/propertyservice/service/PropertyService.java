package com.nitya.rest.propertyservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.nitya.rest.propertyservice.entity.PropertyData;

public interface PropertyService {

	List<PropertyData> findAllPropertyDetails();

	List<PropertyData> findPropertyDetailsByProvider(String provider);

	void deleteAllPropertiesByProvider(String provider);

	ResponseEntity<PropertyData> registerProperty(String provider, PropertyData propertyData);

	void deletePropertyById(Integer id);
}
