package com.example.testDEMO.repository;

import com.example.testDEMO.model.Product;
import com.example.testDEMO.model.Rating;
import com.example.testDEMO.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRatingRepository extends CrudRepository<Rating,Long> {
    List<Rating> findByUser(User user);
    List<Rating> findByProduct(Product product);
}
