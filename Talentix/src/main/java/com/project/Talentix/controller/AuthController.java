package com.project.Talentix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.Talentix.request.LoginRequest;
import com.project.Talentix.request.UserRegstrationRequest;
import com.project.Talentix.request.EmployerRegstrationRequest;
import com.project.Talentix.service.AuthService;

@RestController
public class AuthController {

	@Autowired
	private AuthService authService;

	
	@PostMapping("/registerUser")
	public String registerUser(@ModelAttribute UserRegstrationRequest req) {
		authService.RegisterUser(req);
		return "Result"; // your result JSP page
	}
	
	@PostMapping("/registerEmployer")
	public String registerEmployer(@ModelAttribute EmployerRegstrationRequest req) {
		authService.RegisterEmployer(req);
		return "Result"; // your result JSP page
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute LoginRequest req) {
		authService.Login(req);
		return "Result"; // your result JSP page
	}
}
