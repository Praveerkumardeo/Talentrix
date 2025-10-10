package com.project.Talentix.serviceImpl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.project.Talentix.models.Notification;
import com.project.Talentix.models.User;
import com.project.Talentix.repo.NotificationRepo;
import com.project.Talentix.repo.UserRepo;
import com.project.Talentix.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	private UserRepo userRepo;
	
    @Autowired
    private NotificationRepo notificationRepo;
	
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendNotification(int userId, String message) {
        User user = userRepo.findById(userId);

        if (user == null) {
            System.out.println("User not found for ID: " + userId);
            return;
        }

        // 1️⃣ Send Email
        String email = user.getEmail();
        if (email != null && !email.isEmpty()) {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(email);
            mailMessage.setSubject("Notification from Talentix");
            mailMessage.setText(message);
            mailMessage.setFrom("praveerkumardeo2@gmail.com");
            mailSender.send(mailMessage);

            System.out.println("Email sent to " + email);
        }

        // 2️⃣ Save Notification in DB
        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setUsers(Collections.singletonList(user)); // associate with one user

        notificationRepo.save(notification);
        System.out.println("Notification saved in DB for user: " + user.getName());
    }

}
