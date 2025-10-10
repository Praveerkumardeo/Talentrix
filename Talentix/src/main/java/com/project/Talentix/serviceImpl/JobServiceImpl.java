package com.project.Talentix.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Talentix.models.Job;
import com.project.Talentix.models.Token;
import com.project.Talentix.models.User;
import com.project.Talentix.repo.JobRepo;
import com.project.Talentix.repo.UserRepo;
import com.project.Talentix.request.AddJobRequest;
import com.project.Talentix.request.UpdateJobRequest;
import com.project.Talentix.service.JobService;

import jakarta.servlet.http.HttpSession;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepo jobRepository;
    
    @Autowired
    private UserRepo userRepo;

    @Override
    public Job getJobById(Integer id) {
        Optional<Job> job = jobRepository.findById(id);
        return job.orElse(null);
    }

    @Override
    public void createJob(AddJobRequest req, HttpSession session) {
    		Token token = (Token) session.getAttribute("token");
    		int id = token.getId();
    		User user = userRepo.findById(id);
    		
    		
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    		

    	
    			Job newJob = new Job();
    					newJob.setJobTitle(req.getTitle());
    					newJob.setJobLocation(req.getLocation());
    					newJob.setRequiredSkills(req.getSkill());
    					newJob.setJobDescription(req.getDescription());
    					newJob.setApplicationDeadline(req.getDeadline());
    					newJob.setSalary(req.getSalary());
    					newJob.setNumberOfPositions(req.getNumberOfPositions());
    					newJob.setJobType(req.getType());
    					newJob.setCategories(req.getCategories());
    					newJob.setPostedBy(user);
    					newJob.setPostedDate(new java.util.Date());
    					newJob.setCompanyName(user.getCompanyName());
    					
    												
    					
        jobRepository.save(newJob);
    }

    @Override
    public void deleteJob(Integer id) {
        jobRepository.deleteById(id);
    }

    @Override
    public Job updateJob(UpdateJobRequest updateJobRequest) {
        Optional<Job> jobOptional = jobRepository.findById(updateJobRequest.getId());
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();

            if (updateJobRequest.getTitle() != null)
                job.setJobTitle(updateJobRequest.getTitle());
            if (updateJobRequest.getLocation() != null)
                job.setJobLocation(updateJobRequest.getLocation());
            if (updateJobRequest.getSkill() != null)
                job.setRequiredSkills(updateJobRequest.getSkill());
            if (updateJobRequest.getDescription() != null)
                job.setJobDescription(updateJobRequest.getDescription());

            return jobRepository.save(job);
        }
        return null;
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public List<Job> getJobByTitle(String title) {
        return jobRepository.findByJobTitle(title);
    }

    @Override
    public List<Job> getJobByLocation(String location) {
        return jobRepository.findByJobLocation(location);
    }

    @Override
    public List<Job> getJobBySkill(String skill) {
        return jobRepository.findBySkill(skill);
    }
}