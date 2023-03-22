package com.example.testDEMO.service;

import com.example.testDEMO.exception.EntityNotFoundException;
import com.example.testDEMO.model.Organization;
import com.example.testDEMO.model.User;
import com.example.testDEMO.repository.IOrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrganizationService {
    private IOrganizationRepository organizationRepository;

    public List<Organization> getAllDiscounts(){
        return (List<Organization>) organizationRepository.findAll();
    }

    public Organization getOrganizationById(Long id){
        return organizationRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Organiation not found with id"+id));
    }

    @Transactional
    public Organization createOrganization(Organization organization){
        return organizationRepository.save(organization);
    }
    @Transactional
    public Organization updateOrganization(Organization organization){
        return organizationRepository.save(organization);
    }
    @Transactional
    public  void deleteOrganization(Long id){
       organizationRepository.deleteById(id);
    }

    public Organization getOrganizationByUser(User user){
        return organizationRepository.findByUser(user);
    }
}
