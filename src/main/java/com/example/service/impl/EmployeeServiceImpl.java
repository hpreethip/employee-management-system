package com.example.service.impl;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.EmployeeRequest;
import com.example.dto.EmployeeResponse;
import com.example.dto.ShiftRequest;
import com.example.dto.ShiftResponse;
import com.example.exception.ResourceNotFoundException;
import com.example.model.ContractType;
import com.example.model.Employee;
import com.example.model.Shift;
import com.example.model.Skill;
import com.example.repo.ContractTypeRepo;
import com.example.repo.EmployeeRepo;
import com.example.repo.ShiftRepo;
import com.example.repo.SkillRepo;
import com.example.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ShiftRepo shiftRepo;

    @Autowired
    private ContractTypeRepo contractTypeRepo;

    @Autowired
    private SkillRepo skillRepo;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
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
    public ShiftResponse addShift(ShiftRequest req) {

        Optional<Employee> e = employeeRepo.findById(req.getEmployeeId());
        if (!e.isPresent()) {
            throw new ResourceNotFoundException("Employee", "employeeId", req.getEmployeeId());
        }

        Optional<Skill> skill = skillRepo.findById(req.getSkillId());
        if (!skill.isPresent()) {
            throw new ResourceNotFoundException("Skill", "skillId", req.getSkillId());
        }

        Shift s = new Shift();
        s.setEmployeeId(req.getEmployeeId());
        s.setSkillId(req.getSkillId());
        s.setTotalDuration(req.getTotalDuration());
        s.setBreakDuration(req.getBreakDuration());
        s.setCreatedAt(ZonedDateTime.now());
        s.setUpdatedAt(ZonedDateTime.now());
        s = shiftRepo.save(s);

        return objectMapper.convertValue(s, ShiftResponse.class);
    }

}
