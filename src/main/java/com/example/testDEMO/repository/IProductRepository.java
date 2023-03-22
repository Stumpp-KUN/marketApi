package com.example.testDEMO.repository;

import com.example.testDEMO.model.Organization;
import com.example.testDEMO.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByNameContaining(String name);
    List<Product> findByOrganization(Organization organization);
}
