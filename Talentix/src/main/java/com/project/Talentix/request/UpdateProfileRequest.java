package com.project.Talentix.request;

public class UpdateProfileRequest {
	String name;
	 
	String email;
	
	String password;
	
	String phoneNumber;
	
	String companyName; // for employer
	
	String resume;

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





	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getResume() {
		return resume;
	}


	
	

}
