package com.project.Talentix.models;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int notiId;
	String message;
	
	 @ManyToMany
	    @JoinTable(
	        name = "user_notifications",
	        joinColumns = @JoinColumn(name = "notification_id"),
	        inverseJoinColumns = @JoinColumn(name = "user_id")
	    )
	List<User> users;


	 
	 
	 // Getters & Setters
	 
	 public int getNotiId() {
		 return notiId;
	 }

	 public void setNotiId(int notiId) {
		 this.notiId = notiId;
	 }

	 public String getMessage() {
		 return message;
	 }

	 public void setMessage(String message) {
		 this.message = message;
	 }

	 public List<User> getUsers() {
		 return users;
	 }

	 public void setUsers(List<User> users) {
		 this.users = users;
	 }

	 public Notification(int notiId, String message, List<User> users) {
		super();
		this.notiId = notiId;
		this.message = message;
		this.users = users;
	 }

	 public Notification() {
		super();
	 }
	 
	 
	 
}