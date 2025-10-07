package com.project.Talentix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.Talentix.request.UserRegstrationRequest;
import com.project.Talentix.service.AuthService;

@Controller
public class HomeController {
	// Add methods to handle requests here

	@Autowired
	AuthService authService;

	@RequestMapping("/")
	public String home() {
		return "RegisterEmployer"; // returns the view name
	}

//	@RequestMapping("/registerUser")
//	public String Register(@RequestParam String name, @RequestParam String email, @RequestParam String password, @RequestParam int phone) {
//		UserRegstrationRequest req = new UserRegstrationRequest();
//		req.setName(name);
//		req.setEmail(email);
//		req.setPassword(password);
//		req.setPhone(phone);
//		
//		authService.RegisterUser(req);
//		 return "Result";
//	}


}
