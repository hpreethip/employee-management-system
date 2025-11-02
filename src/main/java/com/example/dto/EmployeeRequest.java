package com.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "Request object for creating a new employee")
public class EmployeeRequest {

    @NotBlank(message = "Employee name is required")
    @Schema(description = "Name of the employee", requiredMode = Schema.RequiredMode.REQUIRED, example = "John Doe")
    private String name;

    @NotBlank(message = "Contract type ID is required")
    @Schema(description = "Unique identifier of the contract type", requiredMode = Schema.RequiredMode.REQUIRED, example = "550e8400-e29b-41d4-a716-446655440000")
    private String contractTypeId;
}
