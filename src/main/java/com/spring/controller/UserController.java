package com.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.UserRequest;
import com.spring.entity.User;
import com.spring.service.UserService;
import com.spring.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	public UserService  service;
	
		
	public UserController(UserService service) {
		super();
		this.service = service;
	}

	// Resource Oriented Design(ROD)

	
	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody @Valid User user)
	{
		return service.saveUser(user);
		
	}
	

}
