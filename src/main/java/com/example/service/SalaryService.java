package com.example.service;

import org.springframework.stereotype.Repository;

import com.example.dto.SalaryResponse;

@Repository
public interface SalaryService {

    SalaryResponse calculateSalary(String employeeId);

}
