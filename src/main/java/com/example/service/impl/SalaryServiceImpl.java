package com.example.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.SalaryResponse;
import com.example.exception.ResourceNotFoundException;
import com.example.model.ContractType;
import com.example.model.Employee;
import com.example.model.Shift;
import com.example.model.Skill;
import com.example.repo.ContractTypeRepo;
import com.example.repo.EmployeeRepo;
import com.example.repo.ShiftRepo;
import com.example.repo.SkillRepo;
import com.example.service.SalaryService;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SkillRepo skillRepo;

    @Autowired
    private ContractTypeRepo contractTypeRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ShiftRepo shiftRepo;

    @Override
    public SalaryResponse calculateSalary(String employeeId) {

        BigDecimal ctPay = BigDecimal.ZERO;
        BigDecimal sPay = BigDecimal.ZERO;
        BigDecimal totalWorkedHours = BigDecimal.ZERO;
        Optional<Employee> e = employeeRepo.findById(employeeId);
        if (e.isPresent()) {
            Iterable<Shift> shifts = shiftRepo.findAllById(e.get().getShiftIds());
            for (Shift shift : shifts) {
                Optional<Skill> skill = skillRepo.findById(shift.getSkillId());
                if (skill.isPresent()) {
                    BigDecimal actualHours = shift.getTotalDuration().subtract(shift.getBreakDuration());
                    totalWorkedHours = totalWorkedHours.add(actualHours);
                    BigDecimal sRate = skill.get().getRate();
                    sPay = sPay.add(actualHours.multiply(sRate));
                } else {
                    throw new ResourceNotFoundException("Skill", "skillId", shift.getSkillId());
                }
            }

            Optional<ContractType> ct = contractTypeRepo.findById(e.get().getContractTypeId());
            if (ct.isPresent()) {
                BigDecimal CtRate = ct.get().getRate();
                ctPay = totalWorkedHours.multiply(CtRate);
            } else {
                throw new ResourceNotFoundException("ContractType", "contractTypeId", e.get().getContractTypeId());
            }

        } else {
            throw new ResourceNotFoundException("Employee", "employeeId", employeeId);
        }

        SalaryResponse res = new SalaryResponse();
        res.setEmployeeId(employeeId);
        res.setPay(ctPay.add(sPay));

        return res;
    }

}
