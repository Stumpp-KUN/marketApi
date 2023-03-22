package com.example.testDEMO.repository;

import com.example.testDEMO.model.Characteristic;
import org.springframework.data.repository.CrudRepository;

public interface ICharacteristicRepository extends CrudRepository<Characteristic,Long> {
}
