package com.example.testDEMO.repository;

import com.example.testDEMO.model.Organization;
import com.example.testDEMO.model.User;
import org.springframework.data.repository.CrudRepository;

public interface IOrganizationRepository extends CrudRepository<Organization,Long> {
    Organization findByUser(User user);
}
