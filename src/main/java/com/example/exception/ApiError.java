package com.example.exception;

import java.time.ZonedDateTime;

import lombok.Data;

@Data
public class ApiError {

    private ZonedDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    ApiError() {
        this.timestamp = ZonedDateTime.now();
    }

}
