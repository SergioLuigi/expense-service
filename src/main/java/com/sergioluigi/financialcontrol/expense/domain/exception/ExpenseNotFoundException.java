package com.sergioluigi.financialcontrol.expense.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Expense not found")
public class ExpenseNotFoundException extends RuntimeException { }
