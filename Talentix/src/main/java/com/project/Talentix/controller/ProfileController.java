package com.project.Talentix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Talentix.request.UpdateProfileRequest;
import com.project.Talentix.service.ProfileService;

@RestController
public class ProfileController {

	@Autowired
    private ProfileService profileService;

    @PostMapping("/updateProfile")
    public String updateProfile(@ModelAttribute UpdateProfileRequest request) {
        profileService.updateProfile(request);
        return "result"; // now works for JSP redirect
    }
}
