package com.project.Talentix.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.Talentix.models.Job;
import com.project.Talentix.models.JobApplications;
import com.project.Talentix.models.User;

import jakarta.transaction.Transactional;

public interface JobApplicationRepo extends JpaRepository<JobApplications, Integer> {

	 @Modifying
	    @Transactional
	    @Query("INSERT INTO JobApplications (userId, jobId, status) VALUES (:userId, :jobId, 'Applied')")
	    void addApplication(@Param("userId") int userId, @Param("jobId") int jobId);

	    // 🔹 Remove application
	    @Modifying
	    @Transactional
	    @Query("DELETE FROM JobApplications ja WHERE ja.userId = :userId AND ja.jobId = :jobId")
	    void removeApplication(@Param("userId") int userId, @Param("jobId") int jobId);

	    // 🔹 Find all jobs applied by a user
	    @Query("SELECT j FROM Job j WHERE j.id IN (SELECT ja.jobId FROM JobApplications ja WHERE ja.userId = :userId)")
	    List<Job> findAppliedJobs(@Param("userId") int userId);

	    // 🔹 Find job status for a user and job
	    @Query("SELECT ja.status FROM JobApplications ja WHERE ja.userId = :userId AND ja.jobId = :jobId")
	    String findJobStatus(@Param("userId") int userId, @Param("jobId") int jobId);
    
    
}

