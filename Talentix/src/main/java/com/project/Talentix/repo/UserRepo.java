package com.project.Talentix.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.Talentix.models.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	User findByEmail(String email);

	@Query("SELECT u.email FROM User u WHERE u.id = :id")
    String findEmailById(@Param("id") int id);
}
