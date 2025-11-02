package com.example.service.impl;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.EmployeeRequest;
import com.example.dto.EmployeeResponse;
import com.example.entity.ContractType;
import com.example.entity.Employee;
import com.example.exception.ResourceNotFoundException;
import com.example.repo.ContractTypeRepo;
import com.example.repo.EmployeeRepo;
import com.example.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ContractTypeRepo contractTypeRepo;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    @Transactional
    public EmployeeResponse createEmployee(EmployeeRequest req) {

        Optional<ContractType> ct = contractTypeRepo.findById(req.getContractTypeId());
        if (!ct.isPresent()) {
            throw new ResourceNotFoundException("ContractType", "contractTypeId", req.getContractTypeId());
        }

        Employee emp = new Employee();
        emp.setName(req.getName());
        emp.setContractTypeId(req.getContractTypeId());
        emp.setShiftIds(Collections.emptyList());
        emp.setCreatedAt(ZonedDateTime.now());
        emp.setUpdatedAt(ZonedDateTime.now());
        emp = employeeRepo.save(emp);

        return objectMapper.convertValue(emp, EmployeeResponse.class);
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeResponse getEmployee(String id) {
        Optional<Employee> e = employeeRepo.findById(id);
        if (!e.isPresent()) {
            throw new ResourceNotFoundException("Employee", "employeeId", id);
        }
        return objectMapper.convertValue(e.get(), EmployeeResponse.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<EmployeeResponse> getEmployees(Pageable pageable) {
        Page<Employee> employeePage = employeeRepo.findAll(pageable);
        List<EmployeeResponse> content = employeePage.getContent().stream()
                .map(emp -> objectMapper.convertValue(emp, EmployeeResponse.class))
                .collect(Collectors.toList());
        return new PageImpl<>(content, pageable, employeePage.getTotalElements());
    }

}
