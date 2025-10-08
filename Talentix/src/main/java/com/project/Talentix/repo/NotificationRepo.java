package com.project.Talentix.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Talentix.models.Notification;

public interface NotificationRepo extends JpaRepository<Notification, Integer> {

}
