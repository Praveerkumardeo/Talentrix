package com.project.Talentix.models;

public class Token {
	String role;
	int id;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Token(String role, int id) {
		super();
		this.role = role;
		this.id = id;
	}
	
	
	
	
}
