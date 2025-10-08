package com.project.Talentix.models;

import jakarta.persistence.*;

@Entity
@Table(name = "job_applications")
public class JobApplications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    private String status; // Applied, Reviewed, Shortlisted, Rejected

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public JobApplications(User user, Job job, String status) {
		super();
		this.user = user;
		this.job = job;
		this.status = status;
	}

    
}

