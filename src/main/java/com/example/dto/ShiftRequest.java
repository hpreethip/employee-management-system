package com.example.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Schema(description = "Request object for adding a shift to an employee")
public class ShiftRequest {

    @NotBlank(message = "Employee ID is required")
    @Schema(description = "Unique identifier of the employee", requiredMode = Schema.RequiredMode.REQUIRED, example = "550e8400-e29b-41d4-a716-446655440000")
    private String employeeId;

    @NotBlank(message = "Skill ID is required")
    @Schema(description = "Unique identifier of the skill", requiredMode = Schema.RequiredMode.REQUIRED, example = "550e8400-e29b-41d4-a716-446655440000")
    private String skillId;

    @NotNull(message = "Total duration is required")
    @Positive(message = "Total duration must be a positive number")
    @Schema(description = "Total duration of the shift in hours", requiredMode = Schema.RequiredMode.REQUIRED, example = "8.00")
    private BigDecimal totalDuration;

    @NotNull(message = "Break duration is required")
    @Schema(description = "Break duration in hours during the shift", requiredMode = Schema.RequiredMode.REQUIRED, example = "1.00")
    private BigDecimal breakDuration;

}
