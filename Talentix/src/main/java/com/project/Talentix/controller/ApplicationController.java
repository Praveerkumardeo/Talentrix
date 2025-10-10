package com.project.Talentix.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.project.Talentix.models.Job;
import com.project.Talentix.models.Token;
import com.project.Talentix.models.User;
import com.project.Talentix.request.SendNotificationRequest;
import com.project.Talentix.service.ApplicationService;
import com.project.Talentix.service.NotificationService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;
    
    @Autowired
	private NotificationService notificationService;
    
    

    


    // ✅ Apply to a job
    @GetMapping("/apply/{jobId}")
    public ModelAndView applyToJob(@PathVariable int jobId, HttpSession session) {
        applicationService.applyToJob(jobId, session);
        
        ModelAndView mv = new ModelAndView("ApplyJob");
        Token token = (Token) session.getAttribute("token");
        int userId = token.getId();
        notificationService.sendNotification(userId, "You have successfully applied to the job with ID: " + jobId);
        return mv;
    }

    // ✅ Withdraw job application
    @DeleteMapping("/withdraw/{jobId}")
    public ResponseEntity<String> withdrawApplication(@PathVariable int jobId, HttpSession session) {
        applicationService.withdrawApplication(jobId, session);
        return ResponseEntity.ok("Application withdrawn successfully");
    }

    // ✅ View all jobs user has applied to
    @GetMapping("/myApplications")
    public List<Job> viewApplications(HttpSession session) {
        List<Job> jobs = applicationService.viewApplications(session);
        if (jobs == null || jobs.isEmpty()) {
            return null;
        }
        return jobs;
    }

    // ✅ Check job application status
    @GetMapping("/status/{jobId}")
    public void jobStatus(@PathVariable int jobId, HttpSession session) {
        String status = applicationService.jobStatusUpdate(jobId, session);
        if (status == null || status.isEmpty()) {
            return;
        }
        return;
    }
    
    @GetMapping("/changeStatus/{userId}/{status}")
    public ModelAndView changeJobStatus(@PathVariable int userId, @PathVariable String status, HttpSession session) {
    	Token token = (Token) session.getAttribute("token");
		int EId = token.getId();
		applicationService.changeJobStatus(userId, status);
		
		ModelAndView mv = new ModelAndView("Employerapplications");
		applicationService.deleteApplication(EId, userId);
		
		notificationService.sendNotification(userId, "Your application status for job  has been changed to: " + status);
		return mv;
	}
    
    @GetMapping("/verifyApplications")
    public List<User> verifyApplications(HttpSession session) {
		List<User> users = applicationService.verifyApplications(session);
		if (users == null || users.isEmpty()) {
			System.out.println("No users found++++++++++++++++++++++++++++++");
			return new ArrayList<>();
		}
		
		for(User u : users) {
			System.out.println("users are ++++++++++++++++++++++" + u.getName());
		}
		return users;
	}
    
    
    
}