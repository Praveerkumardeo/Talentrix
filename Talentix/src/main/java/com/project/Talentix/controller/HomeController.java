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
		return "Home"; // returns the view name
	}

	@RequestMapping("/registerEmployer")
	public String registerEmployer() {
		return "RegisterEmployer"; // returns the view name
	}
	
	@RequestMapping("/registerUser")
	public String registerUser() {
		return "Register"; // returns the view name
	}

	@RequestMapping("/login")
	public String login() {
		return "Login"; // returns the view name
	}
	
	@RequestMapping("/sendNotification")
	public String sendNotification() {
		return "Notification"; // returns the view name
	}

    @RequestMapping("/updateProfilePage")
    public String showUpdateProfilePage() {
        return "UpdateProfile"; // shows the JSP page
    }

}
