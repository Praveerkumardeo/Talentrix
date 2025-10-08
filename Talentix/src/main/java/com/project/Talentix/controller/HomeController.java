package com.project.Talentix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.Talentix.models.Token;
import com.project.Talentix.request.UserRegstrationRequest;
import com.project.Talentix.service.AuthService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	// Add methods to handle requests here

	@Autowired
	AuthService authService;
	
	// user first lands to home page
	// there will be options to register (user/employer) or login
	
	// after login, user will be redirected to their respective pages based on their roles
	// user -> About
	// employer -> Employer
	
	
	@RequestMapping("/")
	public String home() {
		return "Home"; // returns the view name
	}
	
	
	@RequestMapping("/sendNotification")
	public String sendNotification(HttpSession session) {
		Token token = (Token) session.getAttribute("token");
    	if(token == null) {
    		return "Login"; // your login JSP page
    	}
    	if(token.getRole().equals("User")) {
			return "UserHome"; // your user JSP page
		}
		return "Notification"; // returns the view name
	}

    @RequestMapping("/updateProfilePage")
    public String showUpdateProfilePage(HttpSession session) {
    	Token token = (Token) session.getAttribute("token");
    	if(token == null) {
    		return "Login"; // your login JSP page
    	}
    	
        return "UpdateProfile"; // shows the JSP page
    }
    


}
