package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDTO;
import com.app.dto.UserIdDTO;
import com.app.exceptions.ForbiddenRequestException;
import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.services.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/toDoApp")
public class UserController {
	@Autowired
	private UserServiceImpl userService;

	@PostMapping("/signUp")
	public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
			System.out.println("UserDTO Details :" + userDTO);
			UserIdDTO user = userService.addUser(userDTO);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
	}

	@GetMapping("/allUsers")
	public ResponseEntity<?> getAllUsers(HttpSession session) {
		User currentUser = (User) session.getAttribute("currentUser");
		if (currentUser != null && Role.ADMIN.equals(currentUser.getRole())) {
			List<User> users = userService.getAllUsers();
			return ResponseEntity.status(HttpStatus.OK).body(users);
		} else {
			
			throw new ForbiddenRequestException("Only Admin can access this feature");
		}
	}
	
	@DeleteMapping("/deleteUser")
	public ResponseEntity<?> deleteUser(HttpSession session){
		String statement = userService.deleteUser(session);
		return ResponseEntity.status(HttpStatus.OK).body(statement);
	}
}
