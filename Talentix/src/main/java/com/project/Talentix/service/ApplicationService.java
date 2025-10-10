package com.project.Talentix.service;



import jakarta.servlet.http.HttpSession;
import java.util.List;
import com.project.Talentix.models.Job;
import com.project.Talentix.models.User;

public interface ApplicationService {
	void applyToJob(int jobId, HttpSession session);
	void withdrawApplication(int jobId, HttpSession session);
	List<Job> viewApplications(HttpSession session);
	String jobStatusUpdate(int jobId, HttpSession session);
	void changeJobStatus(int jobId, String status);
	List<User> verifyApplications(HttpSession session);
	
	void deleteApplication(int eId, int userId);
}
