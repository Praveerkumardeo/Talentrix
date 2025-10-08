package com.project.Talentix.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.Talentix.models.Job;

public interface JobRepo extends JpaRepository<Job, Integer> {

}
