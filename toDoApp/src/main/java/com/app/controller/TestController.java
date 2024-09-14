package com.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class TestController {
	@GetMapping("test")
	public String testEndPoint() {
		System.out.println("API request recieved sent the response check the browser");
		return "Spring Boot application is working correctly";
	}
}
