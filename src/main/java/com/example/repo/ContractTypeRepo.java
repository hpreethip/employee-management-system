package com.example.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.ContractType;

@Repository
public interface ContractTypeRepo extends CrudRepository<ContractType, String> {

}
