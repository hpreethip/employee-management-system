package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.constant.RequestUri;
import com.example.dto.EmployeeRequest;
import com.example.dto.EmployeeResponse;
import com.example.dto.ShiftRequest;
import com.example.dto.ShiftResponse;
import com.example.service.EmployeeService;
import com.example.service.ShiftService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ShiftService shiftService;

    @PostMapping(value = RequestUri.EMPLOYEE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(req));
    }

    @GetMapping(value = RequestUri.EMPLOYEE_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponse> getEmployees(@PathVariable String id) {
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }

    @GetMapping(value = RequestUri.EMPLOYEE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<EmployeeResponse>> getEmployees(Pageable pageable) {
        return ResponseEntity.ok(employeeService.getEmployees(pageable));
    }

    @PostMapping(value = RequestUri.EMPLOYEE_SHIFT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShiftResponse> addShift(@RequestBody ShiftRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(shiftService.addShift(req));
    }

}
