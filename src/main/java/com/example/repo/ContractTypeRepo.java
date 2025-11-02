package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.ContractType;

@Repository
public interface ContractTypeRepo extends JpaRepository<ContractType, String> {

}
