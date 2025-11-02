package com.example.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import lombok.Data;

@Data
public class ShiftResponse {

    private String id;
    private String employeeId;
    private String skillId;
    private BigDecimal totalDuration;
    private BigDecimal breakDuration;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

}
