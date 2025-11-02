package com.example.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import com.example.constant.ContractTypeName;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Response object containing contract type details")
public class ContractTypeResponse {

    @Schema(description = "Unique identifier for the contract type", example = "550e8400-e29b-41d4-a716-446655440000")
    private String id;

    @Schema(description = "Type of contract", example = "PERMANENT")
    private ContractTypeName name;

    @Schema(description = "Hourly rate for the contract type", example = "12.50")
    private BigDecimal rate;

    @Schema(description = "Timestamp when the contract type was created", example = "2024-01-15T10:30:00Z")
    private ZonedDateTime createdAt;

    @Schema(description = "Timestamp when the contract type was last updated", example = "2024-01-15T10:30:00Z")
    private ZonedDateTime updatedAt;

}
