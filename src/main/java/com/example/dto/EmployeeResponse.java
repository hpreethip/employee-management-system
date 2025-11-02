package com.example.dto;

import java.time.ZonedDateTime;

import lombok.Data;

@Data
public class EmployeeResponse {
    private String id;
    private String name;
    private String contractTypeId;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
