package com.example.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	
	@RequestMapping("/api/user")
	public String user() {
		return "Hello Api User!";
	}
	
	@RequestMapping("/hello")
	public String everyone() {
		return "Hello Everyone!";
	}
}
