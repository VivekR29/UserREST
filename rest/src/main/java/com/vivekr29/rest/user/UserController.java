package com.vivekr29.rest.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController{
	
	@Autowired
	private UserDAOService userDAOService;
	
	@GetMapping(path="/users")
	public List<User> retriveAllUsers() {
		return userDAOService.findAll();
	}
	
	@GetMapping(path="/user/{id}")
	public User retriveUser(@PathVariable Integer id) {
		User user =  userDAOService.findOne(id);
		if(user==null) {
			throw new UsernotfoundException("id-" + id);
		}
		return user;
	}
	
	@PostMapping("/user")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = userDAOService.save(user);
		URI loc = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(loc).build();
		//return savedUser;
	}
	
	@DeleteMapping(path="/user/{id}")
	public void deleteUser(@PathVariable Integer id) {
		User user =  userDAOService.deleteById(id);
		if(user==null) {
			throw new UsernotfoundException("id-" + id);
		}
		//return user;
	}
	
}
