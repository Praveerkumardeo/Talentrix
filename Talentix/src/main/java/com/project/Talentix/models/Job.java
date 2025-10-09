package com.project.Talentix.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "jobs")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String jobTitle;
	String jobDescription;
	String jobLocation;
	String CompanyName;
	String jobType; // Full-time, Part-time, Contract
	
    @ManyToOne
    @JoinColumn(name = "posted_by_id")
    User postedBy;
	
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	Date postedDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	Date applicationDeadline;
    
	int numberOfPositions;
	
	Double salary;
	
	
	@ElementCollection
	List<String> requiredSkills;
	@ElementCollection
	List<String> categories;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobApplications> applications;
	
	
	
	// Getters & Setters


	public String getJobTitle() {
		return jobTitle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
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



	public List<JobApplications> getApplications() {
		return applications;
	}

	public void setApplications(List<JobApplications> applications) {
		this.applications = applications;
	}





	
	

	public Job(String jobTitle, String jobDescription, String jobLocation, String companyName, String jobType,
			User postedBy, Date postedDate, Date applicationDeadline, int numberOfPositions, double salary,
			List<String> requiredSkills, List<String> categories, List<JobApplications> applications) {
		super();

		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.jobLocation = jobLocation;
		CompanyName = companyName;
		this.jobType = jobType;
		this.postedBy = postedBy;
		this.postedDate = postedDate;
		this.applicationDeadline = applicationDeadline;
		this.numberOfPositions = numberOfPositions;
		this.salary = salary;
		this.requiredSkills = requiredSkills;
		this.categories = categories;
		this.applications = applications;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public Job() {
		super();
	}

	
	
	
}
