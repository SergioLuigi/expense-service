package com.sergioluigi.financialcontrol.expense.infra.controller.dto;

import com.sergioluigi.financialcontrol.expense.domain.Expense;
import com.sergioluigi.financialcontrol.expense.domain.PaymentMethod;

import java.time.LocalDate;

public record NewExpenseResponseDTO(
        Double value,
        LocalDate date,
        String description,
        boolean payed,
        PaymentMethod paymentMethod
) {
    public NewExpenseResponseDTO(Expense expense) {
        this(expense.getValue(),
            expense.getDate(),
            expense.getDescription(),
            expense.isPayed(),
            expense.getPaymentMethod());
    }
}
