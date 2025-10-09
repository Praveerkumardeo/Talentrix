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

    // Add new application
    @Modifying
    @Transactional
    @Query("INSERT INTO JobApplications (user, job, status) VALUES (:user, :job, 'Applied')")
    void addApplication(@Param("user") User user, @Param("job") Job job);

    // Remove application
    @Modifying
    @Transactional
    @Query("DELETE FROM JobApplications ja WHERE ja.user.id = :userId AND ja.job.id = :jobId")
    void removeApplication(@Param("userId") int userId, @Param("jobId") int jobId);

    // Find all jobs applied by a user
    @Query("SELECT ja.job FROM JobApplications ja WHERE ja.user.id = :userId")
    List<Job> findAppliedJobs(@Param("userId") int userId);

    // Find status of a specific job for a user
    @Query("SELECT ja.status FROM JobApplications ja WHERE ja.user.id = :userId AND ja.job.id = :jobId")
    String findJobStatus(@Param("userId") int userId, @Param("jobId") int jobId);
    
    
    
}

