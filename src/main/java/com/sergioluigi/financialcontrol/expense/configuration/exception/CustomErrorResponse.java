package com.sergioluigi.financialcontrol.expense.configuration.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
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