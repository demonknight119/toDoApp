package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDTO;
import com.app.dto.UserIdDTO;
import com.app.services.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping("/signUp")
	public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO){
		UserIdDTO user = userService.addUser(userDTO);
		return null;
		
	}
}
