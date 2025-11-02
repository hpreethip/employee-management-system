package com.example.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Response object containing shift details")
public class ShiftResponse {

    @Schema(description = "Unique identifier for the shift", example = "550e8400-e29b-41d4-a716-446655440000")
    private String id;

    @Schema(description = "Unique identifier of the employee", example = "550e8400-e29b-41d4-a716-446655440000")
    private String employeeId;

    @Schema(description = "Unique identifier of the skill", example = "550e8400-e29b-41d4-a716-446655440000")
    private String skillId;

    @Schema(description = "Total duration of the shift in hours", example = "8.00")
    private BigDecimal totalDuration;

    @Schema(description = "Break duration in hours during the shift", example = "1.00")
    private BigDecimal breakDuration;

    @Schema(description = "Timestamp when the shift was created", example = "2024-01-15T10:30:00Z")
    private ZonedDateTime createdAt;

    @Schema(description = "Timestamp when the shift was last updated", example = "2024-01-15T10:30:00Z")
    private ZonedDateTime updatedAt;

}
