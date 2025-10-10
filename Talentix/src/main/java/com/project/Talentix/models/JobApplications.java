package com.project.Talentix.models;

import jakarta.persistence.*;

@Entity
@Table(name = "job_applications")
public class JobApplications {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int userId;
	private int jobId;

	private String status; // Applied, Reviewed, Shortlisted, Rejected

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public JobApplications(int userId, int jobId, String status) {
		super();
		this.userId = userId;
		this.jobId = jobId;
		this.status = status;
	}

	

}
