package com.parkauto.parkauto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkauto.parkauto.entity.Location;
import com.parkauto.parkauto.repository.ILocationRepository;

@Service
public class LocationService {
	@Autowired
	ILocationRepository locationRepository;
	
	//List of location
	public List<Location> getLocations(){
		return locationRepository.findAll();
	}
	
	//save
	public Location saveLocation(Location location) {
		return locationRepository.save(location);
	}
	
	//get a location
	public Location getLocationById(Long idloc) {
		return locationRepository.findById(idloc).get();
	}
	
	//Delete a location
	
	public void deleteLocation (Location location) {
		locationRepository.delete(location);
	}
	

}
