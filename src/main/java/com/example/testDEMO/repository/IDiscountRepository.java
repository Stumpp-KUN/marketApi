package com.example.testDEMO.repository;

import com.example.testDEMO.model.Discount;
import com.example.testDEMO.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IDiscountRepository extends CrudRepository<Discount,Long> {
    List<Discount> findByProductsContaining(Product product);
}
