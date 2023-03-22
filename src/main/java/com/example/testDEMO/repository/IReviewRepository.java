package com.example.testDEMO.repository;

import com.example.testDEMO.model.Product;
import com.example.testDEMO.model.Review;
import com.example.testDEMO.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IReviewRepository extends CrudRepository<Review,Long> {
    List<Review> findByUser(User user);
    List<Review> findByProduct(Product product);
}
