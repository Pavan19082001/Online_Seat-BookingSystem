package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Location;
import com.example.demo.repository.LocationDAO;

@RestController
public class LocationController {
	@Autowired
	LocationDAO locationDAO;
	
	
	@PostMapping("/addlocation")
	public String addLocation(@RequestBody Location location) {
		locationDAO.save(location);
		return "Location added";

}
	@PatchMapping("/updatelocation")
	public String updateLocation(@RequestBody Location location) {
		locationDAO.save(location);
		return "Location Updated";
	}
	@DeleteMapping("/deletelocation/{id}")
	public String deleteLocation(@PathVariable("id") int locId) {
		locationDAO.deleteById(locId);
		return "Location deleted";
	}
	@GetMapping("/findalllocations")
	public Iterable<Location> findAllLocations() {
		return locationDAO.findAll();
	}
}
