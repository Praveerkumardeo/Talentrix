package com.project.Talentix.register;


import org.springframework.web.bind.annotation.RequestMapping;

import com.project.Talentix.models.User;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class RegisterController {
	@GetMapping("register")
	public String registerUser() {
		// Registration logic here
		return "User registered successfully!";
	}

}
