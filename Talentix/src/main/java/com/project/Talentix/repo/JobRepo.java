package com.project.Talentix.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.Talentix.models.Job;

public interface JobRepo extends JpaRepository<Job, Integer> {
	@Query("SELECT j FROM Job j WHERE j.jobTitle = :title")
	List<Job> findByJobTitle(@Param("title") String title);

	@Query("SELECT j FROM Job j WHERE j.jobLocation = :location")
	List<Job> findByJobLocation(@Param("location") String location);

    
    
    @Query("SELECT j FROM Job j JOIN j.requiredSkills s WHERE s = :skill")
    List<Job> findBySkill(@Param("skill") String skill);

    
    Job findById(int id);

    @Query("SELECT j FROM Job j")
    List<Job> findAlljobs();

}
