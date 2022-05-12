package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.OfficeDetails;
import com.example.demo.repository.OfficeDAO;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class OfficeLocation {
	@Autowired
	OfficeDAO officeDAO;
	
	@PostMapping("/addoffice")
	public String addBooking(@RequestBody OfficeDetails office) {
		officeDAO.save(office);
		return "Seat Successfully Booked";
	}
	@PatchMapping("/updateoffice")
	public String updateOffice(@RequestBody OfficeDetails office) {
		officeDAO.save(office);
		return "SeatModified";
	}
	@DeleteMapping("/deleteoffice/{id}")
	public String deleteOffice(@PathVariable("id") int offId) {
		officeDAO.deleteById(offId);
		return "Office deleted";
	}
	

}
