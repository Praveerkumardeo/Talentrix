package com.project.Talentix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Talentix.request.SendNotificationRequest;
import com.project.Talentix.service.NotificationService;

@RestController
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
	@RequestMapping("/notification")
	public String sendNotification(@ModelAttribute SendNotificationRequest request) {
		notificationService.sendNotification(request.getUserId(), request.getMessage());
		return "Result";
	}
}
