package com.example.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthTestController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello auth";
	}
	
	@RequestMapping("/api/hello")
	public String hello2() {
		return "Hello api auth";
	}
}
