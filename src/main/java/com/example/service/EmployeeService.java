package com.example.service;

import org.springframework.stereotype.Repository;

import com.example.dto.EmployeeRequest;
import com.example.dto.EmployeeResponse;
import com.example.dto.ShiftRequest;
import com.example.dto.ShiftResponse;

@Repository
public interface EmployeeService {

    EmployeeResponse createEmployee(EmployeeRequest req);

    ShiftResponse addShift(ShiftRequest req);

}
