package com.project.Talentix.request;

public class SendNotificationRequest {
		private int userId;
	public SendNotificationRequest(int userId, String message) {
			super();
			this.userId = userId;
			this.message = message;
		}

	private String message;

	// Getters and Setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
