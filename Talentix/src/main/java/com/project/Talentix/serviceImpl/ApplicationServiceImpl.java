package com.project.Talentix.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Talentix.models.Job;
import com.project.Talentix.models.JobApplications;
import com.project.Talentix.models.Token;
import com.project.Talentix.models.User;
import com.project.Talentix.repo.JobApplicationRepo;
import com.project.Talentix.repo.JobRepo;
import com.project.Talentix.repo.UserRepo;
import com.project.Talentix.service.ApplicationService;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private JobApplicationRepo jobApplicationRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private JobRepo jobRepo;

	/**
	 * Candidate applies for a job
	 */
	@Override
	public void applyToJob(int jobId, HttpSession session) {
		Token token = (Token) session.getAttribute("token");
		if (token == null)
			return; // Not logged in
		if (token.getRole().equals("employer"))
			return; // Employers cannot apply

		int userId = token.getId();
		User user = userRepo.findById(userId);
		Job job = jobRepo.findById(jobId);

		if (user == null || job == null)
			return;

		// Check if already applied
		String existing = jobApplicationRepo.findJobStatus(userId, jobId);
		if (existing == null) {
			JobApplications application = new JobApplications(userId, jobId, "Applied");
			jobApplicationRepo.save(application);
		}
	}

	/**
	 * Candidate withdraws their job application
	 */
	@Override
	public void withdrawApplication(int jobId, HttpSession session) {
		Token token = (Token) session.getAttribute("token");
		if (token == null)
			return;
		if (token.getRole().equals("employer"))
			return;

		int userId = token.getId();
		jobApplicationRepo.removeApplication(userId, jobId);
	}

	/**
	 * Candidate views all jobs they applied to
	 */
	@Override
	public List<Job> viewApplications(HttpSession session) {
		Token token = (Token) session.getAttribute("token");

		if (token.getRole().equals("User")) {
			int userId = token.getId();
			return jobApplicationRepo.findAppliedJobs(userId);
		}

		return null;
	}

	/**
	 * Check current status of user's job application
	 */
	@Override
	public String jobStatusUpdate(int jobId, HttpSession session) {
		Token token = (Token) session.getAttribute("token");
		if (token == null)
			return "";
		if (token.getRole().equals("employer"))
			return "";

		int userId = token.getId();
		return jobApplicationRepo.findJobStatus(userId, jobId);
	}

	@Override
	public void changeJobStatus(int userId, String status) {
		// TODO Auto-generated method stub
		jobApplicationRepo.updateJobStatus(userId, status);
	}

	@Override
	public List<User> verifyApplications(HttpSession session) {
		// TODO Auto-generated method stub
		Token token = (Token) session.getAttribute("token");
		if (token.getRole().equals("Employer")) {
			int employerId = token.getId();
			return jobApplicationRepo.findUsersForEmployer(employerId);
		}
		return new ArrayList<>();
	}

	@Override
	public void deleteApplication(int eId, int userId) {
		// TODO Auto-generated method stub
		jobApplicationRepo.deleteByEmployerAndUser(eId, userId);
	}
	
	
	
	
}