package com.vivekr29.rest.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserDAOService userDAOService;
	
	@GetMapping(path="/users")
	public List<User> retriveAllUsers() {
		return userDAOService.findAll();
	}
	
	@GetMapping(path="/user/{id}")
	public User retriveUser(@PathVariable Integer id) {
		return userDAOService.findOne(id);
	}
	
}
