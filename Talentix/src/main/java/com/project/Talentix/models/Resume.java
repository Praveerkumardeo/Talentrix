package com.project.Talentix.models;

import jakarta.persistence.*;

@Entity
@Table(name = "resumes")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String filePath;

    // ✅ Linked to a single user
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    // Getters & Setters
    public int getResumeId() { return id; }
    public void setResumeId(int resumeId) { this.id = resumeId; }

    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    
    
	public Resume(String filePath, User user) {
		super();
		this.filePath = filePath;
		this.user = user;
	}
	public Resume() {
		super();
	}
    
    
    
}
