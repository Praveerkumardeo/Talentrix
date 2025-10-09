package com.project.Talentix.service;



import jakarta.servlet.http.HttpSession;
import java.util.List;
import com.project.Talentix.models.Job;

public interface ApplicationService {
	void applyToJob(int jobId, HttpSession session);
	void withdrawApplication(int jobId, HttpSession session);
	List<Job> viewApplications(HttpSession session);
	String jobStatusUpdate(int jobId, HttpSession session);
}
