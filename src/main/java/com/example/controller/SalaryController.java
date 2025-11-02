package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.constant.RequestUri;
import com.example.dto.SalaryResponse;
import com.example.exception.ApiError;
import com.example.service.SalaryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Salary Management", description = "APIs for calculating employee salaries")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @Operation(summary = "Calculate employee salary", description = "Calculates the total salary for an employee based on their shifts, contract type, and skills.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Salary calculated successfully", content = @Content(schema = @Schema(implementation = SalaryResponse.class))),
            @ApiResponse(responseCode = "404", description = "Employee not found", content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    @GetMapping(value = RequestUri.SALARY, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryResponse> calculateSalary(
            @Parameter(description = "Unique identifier of the employee", required = true, example = "550e8400-e29b-41d4-a716-446655440000") @RequestParam String employeeId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(salaryService.calculateSalary(employeeId));
    }

}
