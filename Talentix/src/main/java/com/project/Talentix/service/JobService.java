package com.project.Talentix.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.project.Talentix.models.Job;
import com.project.Talentix.request.AddJobRequest;
import com.project.Talentix.request.UpdateJobRequest;

import jakarta.servlet.http.HttpSession;

@Service
public interface JobService {

    Job getJobById(Integer id);
    void createJob(AddJobRequest job, HttpSession session);
    void deleteJob(Integer id);
    Job updateJob(UpdateJobRequest updateJobRequest);
    List<Job> getAllJobs();
    List<Job> getJobByTitle(String title);
    List<Job> getJobByLocation(String location);
    List<Job> getJobBySkill(String skill);
}