package com.example.testDEMO.service;

import com.example.testDEMO.exception.EntityNotFoundException;
import com.example.testDEMO.model.Notification;
import com.example.testDEMO.repository.INotificationRepository;
import com.example.testDEMO.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NotificationService {
    private INotificationRepository notificationRepository;
    private IUserRepository userRepository;

    public Notification getNotificationById(Long id){
        return notificationRepository.findById(id).orElseThrow(()->new EntityNotFoundException("There is not notification with id"+id));
    }

    public List<Notification> getNotificationsByUserId(Long id){
        return notificationRepository.findByUser(userRepository.findById(id).get());

    }
}
