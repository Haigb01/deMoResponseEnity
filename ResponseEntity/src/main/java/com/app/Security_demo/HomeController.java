package com.app.Security_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@ResponseBody
	@GetMapping("/")
	public String home() {
		
		return "Hello World!";
	} 
	
	@ResponseBody
	@GetMapping("/user")
	public String user() {
		return "Hello, User";
	}
	@ResponseBody
	@GetMapping("/admin")
	public String admin() {
		return "Hello, Admin!";
	}
}
