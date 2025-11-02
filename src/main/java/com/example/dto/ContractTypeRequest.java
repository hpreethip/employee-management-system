package com.example.dto;

import java.math.BigDecimal;

import com.example.constant.ContractTypeName;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Schema(description = "Request object for creating a new contract type")
public class ContractTypeRequest {

    @NotNull(message = "Contract type name is required")
    @Schema(description = "Type of contract (PERMANENT, AGENCY, or ZERO_HOURS)", requiredMode = Schema.RequiredMode.REQUIRED, example = "PERMANENT")
    private ContractTypeName name;

    @NotNull(message = "Rate is required")
    @Positive(message = "Rate must be a positive number")
    @Schema(description = "Hourly rate for the contract type", requiredMode = Schema.RequiredMode.REQUIRED, example = "12.50")
    private BigDecimal rate;

}
