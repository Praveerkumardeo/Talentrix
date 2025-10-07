package com.project.Talentix.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Talentix.models.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	User findByEmail(String email);
}
