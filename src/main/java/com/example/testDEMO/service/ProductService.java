package com.example.testDEMO.service;

import com.example.testDEMO.exception.EntityNotFoundException;
import com.example.testDEMO.model.Organization;
import com.example.testDEMO.model.Product;
import com.example.testDEMO.model.Rating;
import com.example.testDEMO.model.Review;
import com.example.testDEMO.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {
    private IProductRepository productRepository;

    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Product not found with id "+id));
    }

    @Transactional
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    @Transactional
    public Product updateProduct(Product product){
        return productRepository.save(product);  // save как update по id нжуному
    }

    @Transactional
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public List<Product> searchProductsByName(String name){
        return productRepository.findByNameContaining(name);
    }

    public List<Product> getProductsByOrganization(Organization organization){
        return productRepository.findByOrganization(organization);
    }

    public Review addReviewToProductById(Long id,Review review){
        review.setProduct(getProductById(id));
        return review;
    }

    public Rating addRatingToProductById(Long id, Rating rating){
        rating.setProduct(getProductById(id));
        return rating;
    }
}
