package com.project.Talentix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.Talentix.request.LoginRequest;
import com.project.Talentix.request.UserRegstrationRequest;
import com.project.Talentix.models.Token;
import com.project.Talentix.request.EmployerRegstrationRequest;
import com.project.Talentix.service.AuthService;

import jakarta.servlet.http.HttpSession;


@RestController
public class AuthController {

	@Autowired
	private AuthService authService;

	
	@PostMapping("/registerUser")
	public String registerUser(@ModelAttribute UserRegstrationRequest req, HttpSession session) {
		Token token = authService.RegisterUser(req);
		if(token == null) {
			return "Register"; // your login JSP page
		}
		session.setAttribute("token", token);
		if(token.getRole().equals("Admin")) {
			return "AdminHome"; // your admin JSP page
		}
		else if(token.getRole().equals("Employer")) {
			return "EmployerHome"; // your employer JSP page
		}
		else {
			return "UserHome"; // your user JSP page
		}
		
	}
	
	@PostMapping("/registerEmployer")
	public String registerEmployer(@ModelAttribute EmployerRegstrationRequest req, HttpSession session) {
		Token token = authService.RegisterEmployer(req);
		if(token == null) {
			return "Register"; // your login JSP page
		}
		session.setAttribute("token", token);
		if(token.getRole().equals("Admin")) {
			return "AdminHome"; // your admin JSP page
		}
		else if(token.getRole().equals("Employer")) {
			return "EmployerHome"; // your employer JSP page
		}
		else {
			return "UserHome"; // your user JSP page
		}
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute LoginRequest req, HttpSession session) {
		Token token = authService.Login(req);
		if(token == null) {
			return "Register"; // your login JSP page
		}
		session.setAttribute("token", token);
		if(token.getRole().equals("Admin")) {
			return "AdminHome"; // your admin JSP page
		}
		else if(token.getRole().equals("Employer")) {
			return "EmployerHome"; // your employer JSP page
		}
		else {
			return "UserHome"; // your user JSP page
		}
	}
	

	
   
}
