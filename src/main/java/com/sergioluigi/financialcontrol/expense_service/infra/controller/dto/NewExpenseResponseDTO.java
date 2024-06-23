package com.sergioluigi.financialcontrol.expense_service.infra.controller.dto;

import com.sergioluigi.financialcontrol.expense_service.domain.Expense;

import java.time.LocalDate;

public record NewExpenseResponseDTO(
        Double value,
        LocalDate date,
        String description
) {
    public NewExpenseResponseDTO(Expense expense) {
        this(expense.getValue(), expense.getDate(), expense.getDescription());
    }
}
