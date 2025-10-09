package com.project.Talentix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.Talentix.models.Job;
import com.project.Talentix.service.ApplicationService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    // ✅ Apply to a job
    @PostMapping("/apply/{jobId}")
    public ResponseEntity<String> applyToJob(@PathVariable int jobId, HttpSession session) {
        applicationService.applyToJob(jobId, session);
        return ResponseEntity.ok("Application submitted successfully");
    }

    // ✅ Withdraw job application
    @DeleteMapping("/withdraw/{jobId}")
    public ResponseEntity<String> withdrawApplication(@PathVariable int jobId, HttpSession session) {
        applicationService.withdrawApplication(jobId, session);
        return ResponseEntity.ok("Application withdrawn successfully");
    }

    // ✅ View all jobs user has applied to
    @GetMapping("/my-applications")
    public ResponseEntity<List<Job>> viewApplications(HttpSession session) {
        List<Job> jobs = applicationService.viewApplications(session);
        if (jobs == null || jobs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(jobs);
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