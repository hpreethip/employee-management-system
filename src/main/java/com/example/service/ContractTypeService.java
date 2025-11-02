package com.example.service;

import org.springframework.stereotype.Repository;

import com.example.dto.ContractTypeRequest;
import com.example.dto.ContractTypeResponse;

@Repository
public interface ContractTypeService {

    ContractTypeResponse createContractType(ContractTypeRequest req);

}
