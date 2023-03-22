package com.example.testDEMO.repository;

import com.example.testDEMO.model.Product;
import com.example.testDEMO.model.Purchase;
import com.example.testDEMO.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPurchaseRepository extends CrudRepository<Purchase,Long> {
    List<Purchase> findByUser(User user);
    List<Purchase> findByProduct(Product product);
    Purchase findByProductId(Long id);
    List<Purchase> findByUserId(Long id);
}
