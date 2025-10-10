package com.project.Talentix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.project.Talentix.request.LoginRequest;
import com.project.Talentix.request.UserRegstrationRequest;
import com.project.Talentix.models.Token;
import com.project.Talentix.request.ChangePassRequest;
import com.project.Talentix.request.EmployerRegstrationRequest;
import com.project.Talentix.service.AuthService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/registerUser")
	public ModelAndView registerUser(@ModelAttribute UserRegstrationRequest req, HttpSession session) {
		Token token = authService.RegisterUser(req);
		ModelAndView mv = new ModelAndView();
		if (token == null) {
			mv.setViewName("Home");
		} else {
			session.setAttribute("token", token);
			mv.setViewName("userlanding");
		}

		return mv;
	}

	@PostMapping("/registerEmployer")
	public ModelAndView registerEmployer(@ModelAttribute EmployerRegstrationRequest req, HttpSession session) {
		Token token = authService.RegisterEmployer(req);
		ModelAndView mv = new ModelAndView();
		if (token == null) {
			mv.setViewName("Home");
		} else {
			session.setAttribute("token", token);
			mv.setViewName("Employer");
		}

		return mv;
	}

	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute LoginRequest req, HttpSession session) {
		Token token = authService.Login(req);
		ModelAndView mv = new ModelAndView();
		if (token == null) {
			mv.setViewName("Home"); // your login JSP page
		}
		session.setAttribute("token", token);
		if (token.getRole().equals("ADMIN")) {
			mv.setViewName("Admin");
		} else if (token.getRole().equals("Employer")) {
			mv.setViewName("Employer"); 
		} else {
			mv.setViewName("userlanding"); // your user JSP page
		}
		
		return mv;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView("Home");
	}
	

	@PostMapping("/changePassword")
	public ModelAndView changePassword(@ModelAttribute ChangePassRequest request, HttpSession session) {
		Token token = (Token) session.getAttribute("token");
		ModelAndView mv = new ModelAndView();
		if (token == null) {
			mv.setViewName("Home"); // your login JSP page
			return mv;
		}
		boolean success = authService.changePassword(request, session);
		if (success) {
			mv.setViewName("userlanding"); // Redirect to user landing page after successful password change
		} else {
			mv.setViewName("ChangePass"); // Redirect back to change password page on failure
		}
		return mv;
	}

}
