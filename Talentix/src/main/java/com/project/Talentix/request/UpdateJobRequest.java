package com.project.Talentix.request;

import java.util.List;

public class UpdateJobRequest {
    private Integer id;
    private String title;
    private String location;
    private List<String> skill;
    private String description;

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }



    public List<String> getSkill() {
		return skill;
	}
	public void setSkill(List<String> skill) {
		this.skill = skill;
	}
	public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}