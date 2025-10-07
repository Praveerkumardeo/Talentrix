package com.project.Talentix.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.Talentix.models.Job;
import com.project.Talentix.request.UpdateJobRequest;

@Service
public interface JobService {
	Job getJobById(Long id);
	Job createJob(Job job);
	void deleteJob(Long id);
	Job updateJob(UpdateJobRequest updateJobRequest);
	List<Job> getAllJobs();
	Job getJobByTitle(String title);
	Job getJobByLocation(String location);
	Job getJobBySkill(String skill);
}
