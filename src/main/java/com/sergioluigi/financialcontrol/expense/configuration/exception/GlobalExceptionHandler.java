package com.sergioluigi.financialcontrol.expense.configuration.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CustomErrorResponse methodArgumentNotValidException(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {
        Set<String> errors = new HashSet<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String errorMessage = error.getDefaultMessage();
            if (error instanceof FieldError fieldError) {
                errors.add(fieldError.getField() +" "+ errorMessage);
            } else {
                errors.add(error.getObjectName() +" "+ errorMessage);
            }
        });
        return new CustomErrorResponse(HttpStatus.valueOf(ex.getStatusCode().value()),
                "Validation error",
                errors, request.getRequestURI());
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(ExpenseException.class)
    public CustomErrorResponse expenseExceptionHandler(ExpenseException ex) {
        return ex.getErrorResponse();
    }

}
