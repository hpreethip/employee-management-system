package com.example.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.dto.EmployeeRequest;
import com.example.dto.EmployeeResponse;

@Repository
public interface EmployeeService {

    EmployeeResponse createEmployee(EmployeeRequest req);

    EmployeeResponse getEmployee(String id);

    Page<EmployeeResponse> getEmployees(Pageable pageable);

}
