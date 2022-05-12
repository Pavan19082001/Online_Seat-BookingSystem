package com.example.demo.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.OfficeDAO;
import com.example.demo.repository.UserDAO;




@CrossOrigin(origins="http://localhost:3000")
@RestController
public class UserController {

	@Autowired
	UserDAO userDAO;
	@Autowired
	OfficeDAO officeDAO;
	
	@PostMapping("/registeruser")
	public User registerUser(@RequestBody User users) {
		return userDAO.save(users);	
	}
	@PatchMapping("/modifydetails")
	public String updateDetails(@RequestBody User users) {
		userDAO.save(users);
		return "user details updated";
	}
	@DeleteMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable("id") int uId ) {
		userDAO.deleteById(uId);
		return "UserDeleted";
		
	}
	@GetMapping("/findfloor/{id}")
	public String findFloor(@PathVariable("id")int floorNo ) {
		officeDAO.findById(floorNo);
		return "floorFound";
	}
	@GetMapping("/finduser/{id}") 
	public Optional<User> getUser(@PathVariable int id) {
		Optional<User> opt=userDAO.findById(id);
		if(!opt.isPresent()) {
			throw new UserNotFoundException();
		}
		return userDAO.findById(id);
	}
	
	@GetMapping("/getallusers")
	public List<User> getAllUsers() {
		return userDAO.findAll();
	}
	
	
	
}
