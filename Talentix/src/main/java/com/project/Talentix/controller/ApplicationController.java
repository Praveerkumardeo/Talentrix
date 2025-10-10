package com.project.Talentix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.project.Talentix.models.Job;
import com.project.Talentix.service.ApplicationService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    // ✅ Apply to a job
    @GetMapping("/apply/{jobId}")
    public ModelAndView applyToJob(@PathVariable int jobId, HttpSession session) {
        applicationService.applyToJob(jobId, session);
        ModelAndView mv = new ModelAndView("ApplyJob");
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
    public ResponseEntity<String> jobStatus(@PathVariable int jobId, HttpSession session) {
        String status = applicationService.jobStatusUpdate(jobId, session);
        if (status == null || status.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(status);
    }
}