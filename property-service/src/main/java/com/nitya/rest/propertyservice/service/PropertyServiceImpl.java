package com.nitya.rest.propertyservice.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nitya.rest.propertyservice.entity.Property;
import com.nitya.rest.propertyservice.entity.PropertyData;
import com.nitya.rest.propertyservice.exception.PropertyNotFoundException;
import com.nitya.rest.propertyservice.repository.PropertyRepository;

@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private PropertyRepository propertyRepo;

	@Override
	public List<PropertyData> findAllPropertyDetails() {
		List<Property> propertyList = propertyRepo.findAll();
		if (propertyList.isEmpty()) {
			throw new PropertyNotFoundException("");
		}
		List<PropertyData> propertyListData = new ArrayList<>();
		propertyList.stream().forEach(property -> {
			PropertyData propertyData = new PropertyData();
			BeanUtils.copyProperties(property, propertyData);
			propertyListData.add(propertyData);
		});
		return propertyListData;
	}

	@Override
	public List<PropertyData> findPropertyDetailsByProvider(String provider) {
		List<Property> propertyDetailsList = propertyRepo.findAllByProvider(provider);

		if (propertyDetailsList.isEmpty()) {
			throw new PropertyNotFoundException("for provider: " + provider);
		}
		List<PropertyData> propertyListData = new ArrayList<>();
		propertyDetailsList.stream().forEach(property -> {
			PropertyData propertyData = new PropertyData();
			BeanUtils.copyProperties(property, propertyData);
			propertyListData.add(propertyData);
		});
		return propertyListData;
	}

	@Override
	public void deleteAllPropertiesByProvider(String provider) {
		List<Property> propertyDetails = propertyRepo.findAllByProvider(provider);

		if (propertyDetails.isEmpty()) {
			throw new PropertyNotFoundException("for provider: " + provider);
		}
		propertyRepo.deleteAllByProvider(provider);
	}

	@Override
	public ResponseEntity<PropertyData> registerProperty(String provider, PropertyData propertyData) {
		Property property = new Property();
		BeanUtils.copyProperties(propertyData, property);
		property.setProvider(provider);
		Property savedProperty = propertyRepo.save(property);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}")
				.buildAndExpand(savedProperty.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@Override
	public void deletePropertyById(Integer id) {
		Optional<Property> propertyDetails = propertyRepo.findById(id);

		if (propertyDetails.isEmpty()) {
			throw new PropertyNotFoundException("for Id: " + id);
		}

		propertyRepo.deleteById(id);
	}
}
