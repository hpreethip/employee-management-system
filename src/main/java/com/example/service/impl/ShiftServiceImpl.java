package com.example.service.impl;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ShiftRequest;
import com.example.dto.ShiftResponse;
import com.example.entity.Employee;
import com.example.entity.Shift;
import com.example.entity.Skill;
import com.example.exception.ResourceNotFoundException;
import com.example.repo.EmployeeRepo;
import com.example.repo.ShiftRepo;
import com.example.repo.SkillRepo;
import com.example.service.ShiftService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ShiftServiceImpl implements ShiftService {

    @Autowired
    private ShiftRepo shiftRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private SkillRepo skillRepo;

    @Autowired
    private ObjectMapper objectMapper;

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

        Employee emp = e.get();
        List<String> shiftIds = emp.getShiftIds();
        shiftIds.add(s.getId());
        emp.setShiftIds(shiftIds);
        employeeRepo.save(emp);

        return objectMapper.convertValue(s, ShiftResponse.class);
    }

}
