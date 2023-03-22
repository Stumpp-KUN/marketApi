package com.example.testDEMO.service;

import com.example.testDEMO.exception.EntityNotFoundException;
import com.example.testDEMO.model.Review;
import com.example.testDEMO.repository.IReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewService {
    private IReviewRepository reviewRepository;

    public Review getReviewById(Long id){
        return reviewRepository.findById(id).orElseThrow(()->new EntityNotFoundException("There is not review with id"+id));
    }


}
