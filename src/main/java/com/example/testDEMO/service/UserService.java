package com.example.testDEMO.service;

import com.example.testDEMO.exception.EntityNotFoundException;
import com.example.testDEMO.model.Organization;
import com.example.testDEMO.model.User;
import com.example.testDEMO.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private IUserRepository userRepository;

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->new EntityNotFoundException("User not found with id"+id));
    }
    @Transactional
    public User createUser(User user){
        return userRepository.save(user);
    }
    @Transactional
    public User updateUser(User user){
        return userRepository.save(user);
    }
    @Transactional
    public  void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    @Transactional
    public User updateUserBalance(String username,Double amount){
        User user=getUserByUserName(username);
        user.setAmount(amount);
        return updateUser(user);
    }

    @Transactional
    public User freezeAccount(String username,Boolean froze){
        User user=getUserByUserName(username);
        user.setIsFrozen(froze);
        return updateUser(user);
    }

    public User login(String username,String password){
        User user=getUserByUserName(username);
        if(user.getPassword().equals(password)==false)
            throw new RuntimeException("Wrong password");
        return user;
    }

    @Transactional
    public void deleteUserByUsername(String username){
        userRepository.deleteByUsername(username);
    }

    public User getUserByUserName(String username){
        return userRepository.findByUsername(username);
    }

    @Transactional
    public Organization applyForOrganization(Organization organization, User user){
        user.setOrganization(organization);
        return organization;
    }
}
