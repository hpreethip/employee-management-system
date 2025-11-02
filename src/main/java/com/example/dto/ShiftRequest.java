package com.example.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ShiftRequest {

    private String employeeId;
    private String skillId;
    private BigDecimal totalDuration;
    private BigDecimal breakDuration;

}
