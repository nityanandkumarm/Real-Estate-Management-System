package com.nitya.rest.propertyservice.controller;

import java.util.List;

import com.nitya.rest.propertyservice.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nitya.rest.propertyservice.entity.PropertyData;

import jakarta.validation.Valid;

@RestController
public class PropertyServiceController {

	private final PropertyService propertyService;

	@Autowired
	PropertyServiceController(PropertyService propertyService){
		this.propertyService = propertyService;
	}
	
	@GetMapping(path = "/properties")
	public List<PropertyData> getAllPropertyDetails() {
		return propertyService.findAllPropertyDetails();
	}

	@PostMapping(path = "/properties/{provider}")
	public ResponseEntity<PropertyData> addProperty(@PathVariable String provider, @Valid @RequestBody PropertyData property) {
		return propertyService.registerProperty(provider, property);
	}

	@GetMapping(path = "/properties/{provider}")
	public List<PropertyData> getPropertiesByProvider(@PathVariable String provider) {
		return propertyService.findPropertyDetailsByProvider(provider);
	}

	@DeleteMapping(path = "/properties/all/{provider}")
	public void deleteAllPropertiesByProvider(@PathVariable String provider) {
		propertyService.deleteAllPropertiesByProvider(provider);
	}
	
	@DeleteMapping(path = "/properties/{id}")
	public void deleteParticularProperty(@PathVariable Integer id) {
		propertyService.deletePropertyById(id);
	}
}
