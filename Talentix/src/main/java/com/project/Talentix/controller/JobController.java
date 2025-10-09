package com.project.Talentix.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.project.Talentix.models.Job;
import com.project.Talentix.request.AddJobRequest;
import com.project.Talentix.request.UpdateJobRequest;
import com.project.Talentix.service.JobService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

	@Autowired
	private JobService jobService;

	// ✅ Create a new Job
	@PostMapping("/create")
	public ModelAndView createJob(@ModelAttribute AddJobRequest job, HttpSession session) {
		System.out.println("sdfghjklkjhgfdsdfghjklkjhgfdsdfghjkkjhgfdsdfghjkkjhgfdsdfghjkjhgfd");
		
		 if(job.getSkill() != null && !job.getSkill().isEmpty()) {
		        job.setSkill(Arrays.asList(job.getSkill().get(0).split(",")));
		    }
		    if(job.getCategories() != null && !job.getCategories().isEmpty()) {
		        job.setCategories(Arrays.asList(job.getCategories().get(0).split(",")));
		    }
		    
		    System.out.println("inside ");
		
		jobService.createJob(job, session);
		ModelAndView mv = new ModelAndView("Employer");
		
		return mv;
	}

	// ✅ Get all Jobs
	@GetMapping("/getAll")
	public List<Job> getAllJobs() {
		List<Job> jobs = jobService.getAllJobs();
		return jobs;
	}

	// ✅ Get Job by ID
	@GetMapping("/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable Integer id) {
		Job job = jobService.getJobById(id);
		return (job != null) ? ResponseEntity.ok(job) : ResponseEntity.notFound().build();
	}

	// ✅ Update Job
	@PutMapping("Update")
	public ResponseEntity<Job> updateJob(@RequestBody UpdateJobRequest updateJobRequest) {
		Job updatedJob = jobService.updateJob(updateJobRequest);
		return (updatedJob != null) ? ResponseEntity.ok(updatedJob) : ResponseEntity.notFound().build();
	}

	// ✅ Delete Job
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteJob(@PathVariable Integer id) {
		jobService.deleteJob(id);
		return ResponseEntity.noContent().build();
	}

	// ✅ Search by title, location, or skill
	@GetMapping("/search")
	public List<Job> searchJob(@RequestParam(required = false) String title,
			@RequestParam(required = false) String location, @RequestParam(required = false) String skill) {
		List<Job> job = null;
		if (title != null)
			job = jobService.getJobByTitle(title);
		else if (location != null)
			job = jobService.getJobByLocation(location);
		else if (skill != null)
			job = jobService.getJobBySkill(skill);

		return job;
	}
}