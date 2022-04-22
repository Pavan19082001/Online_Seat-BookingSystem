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

import com.example.demo.model.Booking;
import com.example.demo.model.Location;
import com.example.demo.model.Seat;
import com.example.demo.repository.BookingDAO;
import com.example.demo.repository.LocationDAO;
import com.example.demo.repository.SeatDAO;

@RestController
public class BookingController {
	@Autowired
	private BookingDAO bookingDAO;
	
		@PostMapping("/addbooking")
		public String addBooking(@RequestBody Booking booking) {
			bookingDAO.save(booking);
			return "Seat Successfully Booked";
		}
		@GetMapping("/gettallbookings")
		public Iterable<Booking> getAllBooking(){
			return bookingDAO.findAll();
		}
		
		@GetMapping("/findbooking/{id}")
		public Optional<Booking> findbooking(@PathVariable int bId) {
			return bookingDAO.findById(bId);
		}
}
