package com.example.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import com.example.constant.SkillName;

import lombok.Data;

@Data
public class SkillResponse {

    private String id;
    private SkillName name;
    private BigDecimal rate;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

}
