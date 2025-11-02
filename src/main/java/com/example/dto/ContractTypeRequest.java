package com.example.dto;

import java.math.BigDecimal;

import com.example.constant.ContractTypeName;

import lombok.Data;

@Data
public class ContractTypeRequest {

    private ContractTypeName name;
    private BigDecimal rate;

}
