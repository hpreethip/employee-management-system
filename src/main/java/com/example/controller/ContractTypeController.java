package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.constant.RequestUri;
import com.example.dto.ContractTypeRequest;
import com.example.dto.ContractTypeResponse;
import com.example.service.ContractTypeService;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/v1")
public class ContractTypeController {

    @Autowired
    private ContractTypeService contractTypeService;

    @PostMapping(value = RequestUri.CONTRACT_TYPE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContractTypeResponse> createContractType(@RequestBody ContractTypeRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contractTypeService.createContractType(req));
    }

}
