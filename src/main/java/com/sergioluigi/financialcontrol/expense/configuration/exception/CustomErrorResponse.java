package com.sergioluigi.financialcontrol.expense.configuration.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Set;

public record CustomErrorResponse(
    LocalDateTime timestamp,
    int status,
    String error,
    String message,
    Set<String> errors,
    String path
) {
    public CustomErrorResponse(HttpStatus status,
                               String message,
                               Set<String> errors,
                               String path) {
        this(LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                message, errors, path);
    }
}