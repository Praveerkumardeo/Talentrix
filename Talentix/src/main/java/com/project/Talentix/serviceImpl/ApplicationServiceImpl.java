package com.project.Talentix.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Talentix.models.Token;
import com.project.Talentix.models.User;
import com.project.Talentix.repo.JobApplicationRepo;
import com.project.Talentix.repo.JobRepo;
import com.project.Talentix.repo.UserRepo;
import com.project.Talentix.service.ApplicationService;

import jakarta.servlet.http.HttpSession;

import java.util.List;
import com.project.Talentix.models.Job;
import com.project.Talentix.models.JobApplications;

@Service
public class ApplicationServiceImpl implements ApplicationService {	
	
    @Autowired
    private JobApplicationRepo jobApplicationRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JobRepo jobRepo;

	@Override
	public void applyToJob(int jobId, HttpSession session) {
		// TODO Auto-generated method stub
		Token token = (Token) session.getAttribute("token");
        if (token == null) return;
        if(token.getRole().equals("employer")) return; // Recruiters cannot apply to jobs

        int userId = token.getId();
        User user = userRepo.findById(userId).orElse(null);
        Job job = jobRepo.findById(jobId).orElse(null);

        if (user == null || job == null) return;

        // Check if already applied
        String existing = jobApplicationRepo.findJobStatus(userId, jobId);
        if (existing == null) {
            JobApplications application = new JobApplications(user, job, "Applied");
            jobApplicationRepo.save(application);
        }
	}

	@Override
	public void withdrawApplication(int jobId, HttpSession session) {
		// TODO Auto-generated method stub
		Token token = (Token) session.getAttribute("token");
        if (token == null) return;
        if(token.getRole().equals("employer")) return;

        int userId = token.getId();
        jobApplicationRepo.removeApplication(userId, jobId);
	}

	@Override
	public List<Job> viewApplications(HttpSession session) {
		// TODO Auto-generated method stub
		Token token = (Token) session.getAttribute("token");
        if (token == null) return null;
        if(token.getRole().equals("employer")) return null;

        int userId = token.getId();
        return jobApplicationRepo.findAppliedJobs(userId);
	}

	@Override
	public String jobStatusUpdate(int jobId, HttpSession session) {
		// TODO Auto-generated method stub
		 Token token = (Token) session.getAttribute("token");
	        if (token == null) return "";
	        if(token.getRole().equals("employer")) return "";

	        int userId = token.getId();
	        return jobApplicationRepo.findJobStatus(userId, jobId);
	}


}
