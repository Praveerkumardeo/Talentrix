package com.project.Talentix.request;

public class UserRegstrationRequest {
	private String name;
	private String email;
	private String password;
	private int phone;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "UserRegstrationRequest [name=" + name + ", email=" + email + ", password=" + password + ", phone="
				+ phone + "]";
	}
	
	
}
