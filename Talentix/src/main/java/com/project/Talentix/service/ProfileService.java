package com.project.Talentix.service;
import org.springframework.stereotype.Service;

import com.project.Talentix.request.UpdateProfileRequest;

@Service
public interface ProfileService {
	void updateProfile(UpdateProfileRequest request);
	
}
