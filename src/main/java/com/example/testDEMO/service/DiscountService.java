package com.example.testDEMO.service;

import com.example.testDEMO.exception.EntityNotFoundException;
import com.example.testDEMO.model.Discount;
import com.example.testDEMO.model.Product;
import com.example.testDEMO.repository.IDiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DiscountService {
    private IDiscountRepository discountRepository;

    public List<Discount> getAllDiscounts(){
        return (List<Discount>) discountRepository.findAll();
    }

    public Discount getDiscountById(Long id){
        return discountRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Discount not found with id "+id));
    }

    @Transactional
    public Discount createDiscount(Discount discount){
        return discountRepository.save(discount);
    }

    @Transactional
    public Discount updateDiscount(Discount discount){
        return discountRepository.save(discount);
    }

    @Transactional
    public void deleteDiscount(Long id){
        discountRepository.deleteById(id);
    }

    public List<Discount> getDiscountsByProduct(Product product){
        return discountRepository.findByProductsContaining(product);
    }
}
