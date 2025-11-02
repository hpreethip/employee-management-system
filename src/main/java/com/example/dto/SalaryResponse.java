package com.example.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class SalaryResponse {

    private String employeeId;
    private BigDecimal pay;

}
