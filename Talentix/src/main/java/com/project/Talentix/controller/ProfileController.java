package com.project.Talentix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.Talentix.models.Token;
import com.project.Talentix.request.UpdateProfileRequest;
import com.project.Talentix.service.ProfileService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

	@Autowired
    private ProfileService profileService;

    @PostMapping("/updateProfile")
    public ModelAndView updateProfile(@ModelAttribute UpdateProfileRequest request, HttpSession session) {
    	Token token = (Token) session.getAttribute("token");
    	ModelAndView mv = new ModelAndView();
    	if(token == null) {
    		mv.setViewName("Home");
    		// your login JSP page
    	}
        profileService.updateProfile(request, session);
        String role = token.getRole();
        if(role.equals("Employer")) {
			mv.setViewName("Employer");
		} else if(role.equals("ADMIN")) {
			mv.setViewName("Admin");
		}
		else {
			mv.setViewName("userlanding");
		}
        return mv;
    }
    
}
