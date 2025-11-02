package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.constant.RequestUri;
import com.example.dto.ContractTypeRequest;
import com.example.dto.ContractTypeResponse;
import com.example.exception.ApiError;
import com.example.service.ContractTypeService;

import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Contract Type Management", description = "APIs for managing contract types")
public class ContractTypeController {

    @Autowired
    private ContractTypeService contractTypeService;

    @Operation(summary = "Create a new contract type", description = "Creates and persists a new contract type record. Validates the input and returns the created contract type with generated ID and timestamps.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Contract type created successfully", content = @Content(schema = @Schema(implementation = ContractTypeResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    @PostMapping(value = RequestUri.CONTRACT_TYPE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContractTypeResponse> createContractType(@Valid @RequestBody ContractTypeRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contractTypeService.createContractType(req));
    }

}
