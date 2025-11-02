package com.example.dto;

import java.math.BigDecimal;

import com.example.constant.SkillName;

import lombok.Data;

@Data
public class SkillRequest {

    private SkillName name;
    private BigDecimal rate;

}
