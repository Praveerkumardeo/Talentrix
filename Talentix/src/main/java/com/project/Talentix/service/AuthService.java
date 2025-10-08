package com.project.Talentix.service;

import com.project.Talentix.request.LoginRequest;
import com.project.Talentix.request.UserRegstrationRequest;
import com.project.Talentix.models.Token;
import com.project.Talentix.request.EmployerRegstrationRequest;


public interface AuthService {
	Token RegisterUser(UserRegstrationRequest request);
	Token RegisterEmployer(EmployerRegstrationRequest request);
	Token Login(LoginRequest request);
	
}
