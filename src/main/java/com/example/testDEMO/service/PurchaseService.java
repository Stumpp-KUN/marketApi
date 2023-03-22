package com.example.testDEMO.service;

import com.example.testDEMO.exception.EntityNotFoundException;
import com.example.testDEMO.model.Organization;
import com.example.testDEMO.model.Product;
import com.example.testDEMO.model.Purchase;
import com.example.testDEMO.model.User;
import com.example.testDEMO.repository.IPurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PurchaseService {
    private IPurchaseRepository purchaseRepository;

    public List<Purchase> getAllPurchase(){
        return (List<Purchase>) purchaseRepository.findAll();
    }

    public Purchase getPurchaseById(Long id){
        return purchaseRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Purchase not found with id"+id));
    }

    @Transactional
    public Purchase createPurchase(Purchase purchase){
        return purchaseRepository.save(purchase);
    }
    @Transactional
    public Purchase updatePurchase(Purchase purchase){
        return purchaseRepository.save(purchase);
    }
    @Transactional
    public  void deletePurchase(Long id){
        purchaseRepository.deleteById(id);
    }

    @Transactional
    public Purchase buyProductById(Long id){
        return purchaseRepository.findByProductId(id);
    }

    public List<Purchase> getPurchaseByUser(User user){
        return purchaseRepository.findByUser(user);
    }

    public List<Purchase> getPurchaseByProduct(Product product){
        return purchaseRepository.findByProduct(product);
    }

    public List<Purchase> getPurchaseByUserId(Long id){return purchaseRepository.findByUserId(id);}
}
