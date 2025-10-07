package com.project.Talentix.service;

import com.project.Talentix.request.LoginRequest;
import com.project.Talentix.request.UserRegstrationRequest;
import com.project.Talentix.request.EmployerRegstrationRequest;


public interface AuthService {
	String RegisterUser(UserRegstrationRequest request);
	String RegisterEmployer(EmployerRegstrationRequest request);
	String Login(LoginRequest request);
	
}
