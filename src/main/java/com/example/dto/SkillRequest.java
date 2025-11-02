package com.example.dto;

import java.math.BigDecimal;

import com.example.constant.SkillName;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Schema(description = "Request object for creating a new skill")
public class SkillRequest {

    @NotNull(message = "Skill name is required")
    @Schema(description = "Name of the skill (BAKERY, CHECKOUT_CASHIER, CUSTOMER_SERVICE, SHIFT_LEADER, SECURITY, CLEANING, or DELIVERY_DRIVER)", requiredMode = Schema.RequiredMode.REQUIRED, example = "BAKERY")
    private SkillName name;

    @NotNull(message = "Rate is required")
    @Positive(message = "Rate must be a positive number")
    @Schema(description = "Hourly rate for the skill", requiredMode = Schema.RequiredMode.REQUIRED, example = "2.00")
    private BigDecimal rate;

}
