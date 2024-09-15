package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginRequestDTO;
import com.app.pojos.User;
import com.app.services.UserServiceImpl;


import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/toDoApp")
public class LoginController {
	
	@Autowired
	UserServiceImpl userService;
	
	@PostMapping("login")
	public ResponseEntity<?>login(@RequestBody LoginRequestDTO loginRequest ,HttpSession session ){
		System.out.println("loginRequest :"+loginRequest);
		
		loginRequest.setRole(loginRequest.getRole().toUpperCase());
		User currentUser = userService.authenticate(loginRequest);  
		if(currentUser!=null) {
			currentUser.setPassword(null);
			session.setAttribute("currentUser", currentUser);
			return ResponseEntity.status(HttpStatus.OK).body("Logged in Sucessfully");
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login  failed");
	}

	
}
