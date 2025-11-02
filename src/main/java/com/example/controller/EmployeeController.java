package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.constant.RequestUri;
import com.example.dto.EmployeeRequest;
import com.example.dto.EmployeeResponse;
import com.example.dto.ShiftRequest;
import com.example.dto.ShiftResponse;
import com.example.exception.ApiError;
import com.example.service.EmployeeService;
import com.example.service.ShiftService;

import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Employee Management", description = "APIs for managing employees and their shifts")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ShiftService shiftService;

    @Operation(summary = "Create a new employee", description = "Creates and persists a new employee record. Validates the input and returns the created employee with generated ID and timestamps.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employee created successfully", content = @Content(schema = @Schema(implementation = EmployeeResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "404", description = "Contract type not found", content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    @PostMapping(value = RequestUri.EMPLOYEE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponse> createEmployee(@Valid @RequestBody EmployeeRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(req));
    }

    @Operation(summary = "Get employee by ID", description = "Retrieves a single employee by their unique identifier.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee retrieved successfully", content = @Content(schema = @Schema(implementation = EmployeeResponse.class))),
            @ApiResponse(responseCode = "404", description = "Employee not found", content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    @GetMapping(value = RequestUri.EMPLOYEE_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponse> getEmployee(
            @Parameter(description = "Unique identifier of the employee", required = true, example = "550e8400-e29b-41d4-a716-446655440000") @PathVariable String id) {
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }

    @Operation(summary = "Get all employees", description = "Retrieves a paginated list of all employees. Supports pagination parameters: page, size, and sort.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employees retrieved successfully", content = @Content(schema = @Schema(implementation = Page.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    @GetMapping(value = RequestUri.EMPLOYEE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<EmployeeResponse>> getEmployees(
            @Parameter(description = "Pagination parameters (page, size, sort)", example = "page=0&size=10&sort=name,asc") Pageable pageable) {
        return ResponseEntity.ok(employeeService.getEmployees(pageable));
    }

    @Operation(summary = "Add a shift to an employee", description = "Creates and assigns a new shift to an employee. Validates the input and returns the created shift with generated ID and timestamps.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Shift added successfully", content = @Content(schema = @Schema(implementation = ShiftResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "404", description = "Employee or skill not found", content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    @PostMapping(value = RequestUri.EMPLOYEE_SHIFT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShiftResponse> addShift(@Valid @RequestBody ShiftRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(shiftService.addShift(req));
    }

}
