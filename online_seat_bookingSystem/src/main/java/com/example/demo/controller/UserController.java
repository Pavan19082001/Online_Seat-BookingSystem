package com.example.demo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.OfficeDAO;
import com.example.demo.repository.UserDAO;

@RestController
public class UserController {
	@Autowired
	private UserDAO userDAO;
	private OfficeDAO officeDAO;
	
	@PostMapping("/user/register")
	public ResponseEntity<String> addNewUser(@RequestBody User user) {
		userDAO.save(user);
		return new ResponseEntity<String>("new user added...", HttpStatus.OK);
	}
	
	@PostMapping("/user/login")
	public String authenticateUser(@RequestBody User user) {
		
		User to_be_checked = userDAO.getById(user.getUserId());
		if(to_be_checked != null) {
			if(to_be_checked.getEmailId().equals(user.getEmailId()) && to_be_checked.getPassword().equals(user.getPassword())) {
				return "Valid User";
			}else {
				throw new UserNotFoundException();
			}
		}
		throw new UserNotFoundException();
		
	}
	
	@GetMapping("/allusers")
	public List<User> getUserById() {
		return userDAO.findAll();
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		userDAO.deleteById(id);
		return new ResponseEntity<String>("user is deleted", HttpStatus.OK);
	}
	
	@PatchMapping("/updateuser")
	public ResponseEntity<String> updateUser(@RequestBody User user){
		userDAO.save(user);
		return new ResponseEntity<String>("User is updated...",HttpStatus.OK);
	}
	

}
