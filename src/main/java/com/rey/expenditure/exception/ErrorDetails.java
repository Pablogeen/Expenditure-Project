package com.rey.expenditure.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorDetails {

    private String errorCode;
    private String message;
    private String details;
    private LocalDateTime timeStamp;
}
