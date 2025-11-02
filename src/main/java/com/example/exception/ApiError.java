package com.example.exception;

import java.time.ZonedDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Error response object")
public class ApiError {

    @Schema(description = "Timestamp when the error occurred", example = "2024-01-15T10:30:00Z")
    private ZonedDateTime timestamp;

    @Schema(description = "HTTP status code", example = "400")
    private int status;

    @Schema(description = "HTTP error reason", example = "Bad Request")
    private String error;

    @Schema(description = "Detailed error message", example = "Rate must be a positive number")
    private String message;

    @Schema(description = "API path where the error occurred", example = "/api/v1/contract-types")
    private String path;

    ApiError() {
        this.timestamp = ZonedDateTime.now();
    }

}
