package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Admin;
import com.example.demo.model.Location;
import com.example.demo.model.Seat;
import com.example.demo.repository.AdminDAO;
import com.example.demo.repository.BookingDAO;
import com.example.demo.repository.LocationDAO;
import com.example.demo.repository.SeatDAO;

@RestController
public class AdminController {
		@Autowired
		AdminDAO adminDAO;
		@Autowired
		SeatDAO seatDAO;
		@Autowired
		LocationDAO locationDAO;
		@Autowired
		BookingDAO bookingDAO;
		
		@PostMapping("/addadmin")
		public String addAdmin(@RequestBody Admin admin) {
			adminDAO.save(admin);
			return "admin added successfully";
		}
		@DeleteMapping("/deleteadmin/{id}")
		public String deleteAdmin(@PathVariable("id") int adminId) {
			adminDAO.deleteById(adminId);
			return "admin deleted";
		}
		@DeleteMapping("/deletealladmins")
		public String deleteAllAdmins() {
			adminDAO.deleteAll();
			return "all admins deleted";
		}
		
		@PostMapping("/createlocation")
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
		
		@DeleteMapping("/cancelbooking/{id}")
		public String deleteBooking(@PathVariable("id") int bId) {
			bookingDAO.deleteById(bId);
			return "Booking cancelled";
		}
		
		@DeleteMapping("/deleteseat/{id}")
		public String deleteSeat(@PathVariable("id")int sId) {
			seatDAO.deleteById(sId);
			return "Seat Deleted";	
		}
		
}
