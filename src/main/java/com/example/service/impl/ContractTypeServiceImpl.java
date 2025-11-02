package com.example.service.impl;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ContractTypeRequest;
import com.example.dto.ContractTypeResponse;
import com.example.entity.ContractType;
import com.example.repo.ContractTypeRepo;
import com.example.service.ContractTypeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ContractTypeServiceImpl implements ContractTypeService {

    @Autowired
    private ContractTypeRepo contractTypeRepo;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ContractTypeResponse createContractType(ContractTypeRequest req) {

        ContractType ct = new ContractType();
        ct.setName(req.getName());
        ct.setRate(req.getRate());
        ct.setCreatedAt(ZonedDateTime.now());
        ct.setUpdatedAt(ZonedDateTime.now());

        ct = contractTypeRepo.save(ct);

        return objectMapper.convertValue(ct, ContractTypeResponse.class);
    }

}
