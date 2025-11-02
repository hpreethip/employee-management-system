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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @PostMapping(value = RequestUri.EMPLOYEE_SHIFT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShiftResponse> addShift(@RequestBody ShiftRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(shiftService.addShift(req));
    }

}
