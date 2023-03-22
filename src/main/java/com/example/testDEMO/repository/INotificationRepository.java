package com.example.testDEMO.repository;

import com.example.testDEMO.model.Notification;
import com.example.testDEMO.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface INotificationRepository extends CrudRepository<Notification,Long> {
    List<Notification> findByUser(User user);
    List<Notification> findAllById(Long id);
}
