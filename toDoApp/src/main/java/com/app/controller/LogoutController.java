package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/toDoApp")
public class LogoutController {
	@PostMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session){
		try {
			session.invalidate();
			return ResponseEntity.status(HttpStatus.OK).body("Logged Out Sucessfully");
			
		} catch (IllegalStateException e) {
			// TODO: handle exception
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Session Dosent Exist");
		}
		
	}

}
