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

	@Transactional
	@Modifying
	@Query("UPDATE JobApplications ja SET ja.status = :status WHERE ja.userId = :userId")
	void updateJobStatus(@Param("userId") int userId,

			@Param("status") String status);

	@Query(value = "SELECT * FROM users u " + "WHERE u.id IN (" + "SELECT ja.user_id FROM job_applications ja "
			+ "JOIN jobs j ON ja.job_id = j.id " + "WHERE j.posted_by_id = :employerId)", nativeQuery = true)
	List<User> findUsersForEmployer(@Param("employerId") int employerId);

	@Modifying
	@Transactional
	@Query(value = "DELETE ja FROM job_applications ja " +
	               "JOIN jobs j ON ja.job_id = j.id " +
	               "WHERE ja.user_id = :userId AND j.posted_by_id = :employerId",
	       nativeQuery = true)
	void deleteByEmployerAndUser(@Param("employerId") int employerId,
	                             @Param("userId") int userId);

}
