package com.project.Talentix.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Talentix.models.User;
import com.project.Talentix.repo.UserRepo;
import com.project.Talentix.request.UpdateProfileRequest;
import com.project.Talentix.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

	  @Autowired
	    private UserRepo userRepo;

	    @Override
	    public void updateProfile(UpdateProfileRequest request) {
	        // Suppose we identify the user by email (or you can use session ID or userId)
	        User user = userRepo.findByEmail(request.getEmail());
	        if (user == null) {
	            throw new RuntimeException("User not found!");
	        }

	        // Only update fields that have non-null (and non-empty) values
	        if (request.getName() != null && !request.getName().isEmpty()) {
	            user.setName(request.getName());
	        }

	        if (request.getPassword() != null && !request.getPassword().isEmpty()) {
	            user.setPassword(request.getPassword());
	        }

	        if (request.getPhoneNumber() != null && !request.getPhoneNumber().isEmpty()) {
	            user.setPhoneNumber(Integer.parseInt(request.getPhoneNumber()));
	        }


	        if (request.getCompanyName() != null && !request.getCompanyName().isEmpty()) {
	            user.setCompanyName(request.getCompanyName());
	        }

	        if (request.getResume() != null) {
	            user.setResume(request.getResume());
	        }

	        userRepo.save(user);
	    }
	
}
