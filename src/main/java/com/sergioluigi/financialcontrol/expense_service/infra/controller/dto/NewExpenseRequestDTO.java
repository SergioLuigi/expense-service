package com.sergioluigi.financialcontrol.expense_service.infra.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sergioluigi.financialcontrol.expense_service.domain.Expense;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record NewExpenseRequestDTO(
        @NotNull
        Double value,
        @NotNull
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate date,
        @Size(max = 240)
        String description
) {

    public Expense toExpense() {
        return new Expense(value, date, description, false);
    }
}
