package com.coffie.coffie_ai_coach.exception;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {
    private int statusCode;
    private String message;
    private long timestamp;
}
