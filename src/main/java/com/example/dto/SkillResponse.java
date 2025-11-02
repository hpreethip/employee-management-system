package com.example.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import com.example.constant.SkillName;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Response object containing skill details")
public class SkillResponse {

    @Schema(description = "Unique identifier for the skill", example = "550e8400-e29b-41d4-a716-446655440000")
    private String id;

    @Schema(description = "Name of the skill", example = "BAKERY")
    private SkillName name;

    @Schema(description = "Hourly rate for the skill", example = "2.00")
    private BigDecimal rate;

    @Schema(description = "Timestamp when the skill was created", example = "2024-01-15T10:30:00Z")
    private ZonedDateTime createdAt;

    @Schema(description = "Timestamp when the skill was last updated", example = "2024-01-15T10:30:00Z")
    private ZonedDateTime updatedAt;

}
