package com.project.Talentix.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "jobs")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int jobId;
	
	String jobTitle;
	String jobDescription;
	String jobLocation;
	String jobType; // Full-time, Part-time, Contract
	
    @ManyToOne
    @JoinColumn(name = "posted_by_id")
    User postedBy;
	
	Date postedDate;
	Date applicationDeadline;
	int numberOfPositions;
	double salary;
	
	@ElementCollection
	List<String> requiredSkills;
	@ElementCollection
	List<String> categories;
	
    @ManyToMany
    @JoinTable(
        name = "job_applications",
        joinColumns = @JoinColumn(name = "job_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
	List<User> applicants; // List of users who applied for the job
	
	String status; // Applied, Reviewed, Shortlisted, Rejected -> for candidate 
	
	
	
	// Getters & Setters

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public User getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public Date getApplicationDeadline() {
		return applicationDeadline;
	}

	public void setApplicationDeadline(Date applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}

	public int getNumberOfPositions() {
		return numberOfPositions;
	}

	public void setNumberOfPositions(int numberOfPositions) {
		this.numberOfPositions = numberOfPositions;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<String> getRequiredSkills() {
		return requiredSkills;
	}

	public void setRequiredSkills(List<String> requiredSkills) {
		this.requiredSkills = requiredSkills;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public List<User> getApplicants() {
		return applicants;
	}

	public void setApplicants(List<User> applicants) {
		this.applicants = applicants;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Job(int jobId, String jobTitle, String jobDescription, String jobLocation, String jobType, User postedBy,
			Date postedDate, Date applicationDeadline, int numberOfPositions, double salary,
			List<String> requiredSkills, List<String> categories, List<User> applicants, String status) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.jobLocation = jobLocation;
		this.jobType = jobType;
		this.postedBy = postedBy;
		this.postedDate = postedDate;
		this.applicationDeadline = applicationDeadline;
		this.numberOfPositions = numberOfPositions;
		this.salary = salary;
		this.requiredSkills = requiredSkills;
		this.categories = categories;
		this.applicants = applicants;
		this.status = status;
	}

	public Job() {
		super();
	}
	
	
	
}
