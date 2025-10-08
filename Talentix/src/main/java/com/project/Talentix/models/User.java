package com.project.Talentix.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userId;
	
	
	String name;
	 @Column(unique = true, nullable = false)
	String email;
	 @Column(nullable = false)
	String password;
	int phoneNumber;
	@Column(nullable = false)
	String role;
	
	String CompanyName; // for employer
	
	@ManyToMany(mappedBy = "applicants")
    @ElementCollection
	List<Job> jobApplied; // for candidate
    
	@OneToMany(mappedBy = "postedBy", cascade = CascadeType.ALL, orphanRemoval = true)
    @ElementCollection
	List<Job> jobsPosted; // for employer
	
    String resume;
	
	 @ManyToMany(mappedBy = "users")
    @ElementCollection
	List<Notification> notifications;

	 
	 // Getters & Setters
	 
	 public int getUserId() {
		 return userId;
	 }

	 public void setUserId(int userId) {
		 this.userId = userId;
	 }



	 public String getName() {
		return name;
	}

	 public void setName(String name) {
		 this.name = name;
	 }

	 public String getCompanyName() {
		 return CompanyName;
	 }

	 public void setCompanyName(String companyName) {
		 CompanyName = companyName;
	 }

	 public String getEmail() {
		 return email;
	 }

	 public void setEmail(String email) {
		 this.email = email;
	 }

	 public String getPassword() {
		 return password;
	 }

	 public void setPassword(String password) {
		 this.password = password;
	 }



	 public int getPhoneNumber() {
		return phoneNumber;
	}

	 public void setPhoneNumber(int phoneNumber) {
		 this.phoneNumber = phoneNumber;
	 }

	 public String getRole() {
		 return role;
	 }

	 public void setRole(String role) {
		 this.role = role;
	 }

	 public List<Job> getJobApplied() {
		 return jobApplied;
	 }

	 public void setJobApplied(List<Job> jobApplied) {
		 this.jobApplied = jobApplied;
	 }

	 public List<Job> getJobsPosted() {
		 return jobsPosted;
	 }

	 public void setJobsPosted(List<Job> jobsPosted) {
		 this.jobsPosted = jobsPosted;
	 }



	 public String getResume() {
		return resume;
	}

	 public void setResume(String resume) {
		 this.resume = resume;
	 }

	 public List<Notification> getNotifications() {
		 return notifications;
	 }

	 public void setNotifications(List<Notification> notifications) {
		 this.notifications = notifications;
	 }

	 public User(int userId, String name, String email, String password, int phoneNumber, String role,
			String companyName, List<Job> jobApplied, List<Job> jobsPosted, String resume,
			List<Notification> notifications) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.role = role;
		CompanyName = companyName;
		this.jobApplied = jobApplied;
		this.jobsPosted = jobsPosted;
		this.resume = resume;
		this.notifications = notifications;
	}


	 public User() {
		super();
	 }

	 public User(String name, String email, String password, int phoneNumber) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.role = "User";
	 }

	 public User(String name, String email, String password, int phoneNumber, String companyName) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		CompanyName = companyName;
		this.role = "Employer";
	 }


	 
	 
	 
}
