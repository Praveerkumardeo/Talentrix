package com.project.Talentix.service;

import com.project.Talentix.request.UpdateProfileRequest;

import jakarta.servlet.http.HttpSession;


public interface ProfileService {
	void updateProfile(UpdateProfileRequest request, HttpSession session);
	
}
