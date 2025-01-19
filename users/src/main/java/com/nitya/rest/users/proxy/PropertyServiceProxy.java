package com.nitya.rest.users.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nitya.rest.users.entity.PropertyData;

import jakarta.validation.Valid;

//@FeignClient(name = "property-service", url = "localhost:8083")
@FeignClient(name = "property-service")
public interface PropertyServiceProxy {

	@GetMapping(path = "/properties")
	public List<PropertyData> getAllPropertyDetails();

	@PostMapping(path = "/properties/{provider}")
	public ResponseEntity<PropertyData> addProperty(@PathVariable String provider, @Valid @RequestBody PropertyData property);

	@GetMapping(path = "/properties/{provider}")
	public List<PropertyData> getPropertiesByProvider(@PathVariable String provider);

	@DeleteMapping(path = "/properties/all/{provider}")
	public void deleteAllPropertiesByProvider(@PathVariable String provider);

	@DeleteMapping(path = "/properties/{id}")
	public void deleteParticularProperty(@PathVariable Integer id);
}
