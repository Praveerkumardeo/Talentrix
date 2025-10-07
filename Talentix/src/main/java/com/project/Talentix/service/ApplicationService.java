package com.project.Talentix.service;

import org.springframework.stereotype.Service;

@Service
public interface ApplicationService {
	void applyToJob(Long jobId, Long userId);
	void withdrawApplication(Long jobId, Long userId);
	void viewApplications(Long userId);
	String jobStatusUpdate(Long jobId, Long userId);
}
