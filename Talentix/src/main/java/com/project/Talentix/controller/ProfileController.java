package com.project.Talentix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Talentix.models.Token;
import com.project.Talentix.request.UpdateProfileRequest;
import com.project.Talentix.service.ProfileService;

import jakarta.servlet.http.HttpSession;

@RestController
public class ProfileController {

	@Autowired
    private ProfileService profileService;

    @PostMapping("/updateProfile")
    public String updateProfile(@ModelAttribute UpdateProfileRequest request, HttpSession session) {
    	Token token = (Token) session.getAttribute("token");
    	if(token == null) {
    		return "Login"; // your login JSP page
    	}
        profileService.updateProfile(request);
        return "result"; // now works for JSP redirect
    }
    
}
