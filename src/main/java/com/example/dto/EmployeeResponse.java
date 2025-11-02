package com.example.dto;

import java.time.ZonedDateTime;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Response object containing employee details")
public class EmployeeResponse {

    @Schema(description = "Unique identifier for the employee", example = "550e8400-e29b-41d4-a716-446655440000")
    private String id;

    @Schema(description = "Name of the employee", example = "John Doe")
    private String name;

    @Schema(description = "Unique identifier of the contract type", example = "550e8400-e29b-41d4-a716-446655440000")
    private String contractTypeId;

    @Schema(description = "List of unique identifiers for the shifts assigned to the employee", example = "[\"550e8400-e29b-41d4-a716-446655440000\", \"550e8400-e29b-41d4-a716-446655440001\"]")
    private List<String> shiftIds;

    @Schema(description = "Timestamp when the employee was created", example = "2024-01-15T10:30:00Z")
    private ZonedDateTime createdAt;

    @Schema(description = "Timestamp when the employee was last updated", example = "2024-01-15T10:30:00Z")
    private ZonedDateTime updatedAt;
}
