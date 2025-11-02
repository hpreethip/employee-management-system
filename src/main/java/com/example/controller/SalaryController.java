package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.constant.RequestUri;
import com.example.dto.SalaryResponse;
import com.example.service.SalaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @GetMapping(value = RequestUri.SALARY, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryResponse> calculateSalary(@RequestParam String employeeId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(salaryService.calculateSalary(employeeId));
    }

}
