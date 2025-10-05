package com.project.Talentix.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userId;
	
	
	String firstName;
	String lastName;
	 @Column(unique = true, nullable = false)
	String email;
	 @Column(nullable = false)
	String password;
	String phoneNumber;
	@Column(nullable = false)
	String role;
	
	
	@ManyToMany(mappedBy = "applicants")
    @ElementCollection
	List<Job> jobApplied; // for candidate
    
	@OneToMany(mappedBy = "postedBy", cascade = CascadeType.ALL, orphanRemoval = true)
    @ElementCollection
	List<Job> jobsPosted; // for employer
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Resume resume;
	
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

	 public String getFirstName() {
		 return firstName;
	 }

	 public void setFirstName(String firstName) {
		 this.firstName = firstName;
	 }

	 public String getLastName() {
		 return lastName;
	 }

	 public void setLastName(String lastName) {
		 this.lastName = lastName;
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

	 public String getPhoneNumber() {
		 return phoneNumber;
	 }

	 public void setPhoneNumber(String phoneNumber) {
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

	 public Resume getResume() {
		 return resume;
	 }

	 public void setResume(Resume resume) {
		 this.resume = resume;
	 }

	 public List<Notification> getNotifications() {
		 return notifications;
	 }

	 public void setNotifications(List<Notification> notifications) {
		 this.notifications = notifications;
	 }

	 public User(int userId, String firstName, String lastName, String email, String password, String phoneNumber,
			String role, List<Job> jobApplied, List<Job> jobsPosted, Resume resume, List<Notification> notifications) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.jobApplied = jobApplied;
		this.jobsPosted = jobsPosted;
		this.resume = resume;
		this.notifications = notifications;
	 }

	 public User() {
		super();
	 }
	 
	 
	 
}
