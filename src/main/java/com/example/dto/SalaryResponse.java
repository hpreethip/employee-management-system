package com.example.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Response object containing calculated salary details")
public class SalaryResponse {

    @Schema(description = "Unique identifier of the employee", example = "550e8400-e29b-41d4-a716-446655440000")
    private String employeeId;

    @Schema(description = "Calculated total salary amount", example = "1250.50")
    private BigDecimal pay;

}
