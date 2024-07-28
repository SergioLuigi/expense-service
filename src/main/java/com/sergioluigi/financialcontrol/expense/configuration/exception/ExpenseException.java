package com.sergioluigi.financialcontrol.expense.configuration.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ExpenseException extends RuntimeException {
    private final CustomErrorResponse errorResponse;
}
