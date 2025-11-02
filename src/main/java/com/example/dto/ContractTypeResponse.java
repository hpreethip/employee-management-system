package com.example.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import com.example.constant.ContractTypeName;

import lombok.Data;

@Data
public class ContractTypeResponse {

    private String id;
    private ContractTypeName name;
    private BigDecimal rate;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

}
