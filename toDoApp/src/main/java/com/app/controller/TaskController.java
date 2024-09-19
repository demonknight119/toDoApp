package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.TaskDTO;
import com.app.dto.TaskResponseDTO;
import com.app.pojos.User;
import com.app.services.TaskServiceImpl;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/todoapp")
public class TaskController {
	
	@Autowired
	private TaskServiceImpl taskService;
	
	@PostMapping("/createTask")
	public ResponseEntity<?> createTask(@RequestBody TaskDTO taskDTO, HttpSession session){
		
		User currentUser = (User) session.getAttribute("currentUser");
		System.out.println("CurrentUser"+currentUser);
		if(currentUser!=null && currentUser.getRole().toString().toUpperCase().equals("USER")) {
			TaskResponseDTO task = taskService.addTask(currentUser,taskDTO);
			return ResponseEntity.status(HttpStatus.OK).body(task);
		}else {
			if(currentUser == null) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Please Login");
			}else {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("ADMIN cant create a task");
			}
		}
	}
}
