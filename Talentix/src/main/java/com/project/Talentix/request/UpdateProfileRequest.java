package com.project.Talentix.request;

public class UpdateProfileRequest {
	String name;
	 
	String phoneNumber;
	
	String companyName; // for employer
	
	String resume;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
