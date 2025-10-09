package com.project.Talentix.request;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class AddJobRequest {
	private String title;
	private String location;
	private List<String> skill;
	private String description;
	// deadline, salary, numberOfPositions, type, categories
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deadline;
	private Double salary;
	private int numberOfPositions;
	private String type;
	private List<String> categories;
	

	// Getters and Setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}



	public List<String> getSkill() {
		return skill;
	}

	public void setSkill(List<String> skill) {
		this.skill = skill;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}


	public int getNumberOfPositions() {
		return numberOfPositions;
	}

	public Double getSalary() {
		return salary;
	}

	public void setNumberOfPositions(int numberOfPositions) {
		this.numberOfPositions = numberOfPositions;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AddJobRequest(String title, String location, List<String> skill, String description, Date deadline,
			Double salary, int numberOfPositions, String type, List<String> categories) {
		super();
		this.title = title;
		this.location = location;
		this.skill = skill;
		this.description = description;
		this.deadline = deadline;
		this.salary = salary;
		this.numberOfPositions = numberOfPositions;
		this.type = type;
		this.categories = categories;
	}
	
	
}
