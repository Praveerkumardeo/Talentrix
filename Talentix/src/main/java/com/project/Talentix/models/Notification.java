package com.project.Talentix.models;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String message;
	
	 @ManyToMany
	    @JoinTable(
	        name = "user_notifications",
	        joinColumns = @JoinColumn(name = "notification_id"),
	        inverseJoinColumns = @JoinColumn(name = "user_id")
	    )
	List<User> users;


	 
	 
	 // Getters & Setters
	 


	 public String getMessage() {
		 return message;
	 }

	 public int getId() {
		return id;
	}

	 public void setId(int id) {
		 this.id = id;
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

	 public Notification(String message, List<User> users) {
		super();
		this.message = message;
		this.users = users;
	 }

	 public Notification() {
		super();
	 }
	 
	 
	 
}