package com.example.testDEMO.repository;

import com.example.testDEMO.model.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
    void deleteByUsername(String username);
}
