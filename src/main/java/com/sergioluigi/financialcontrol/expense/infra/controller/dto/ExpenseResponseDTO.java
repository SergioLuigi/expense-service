package com.sergioluigi.financialcontrol.expense.infra.controller.dto;

import com.sergioluigi.financialcontrol.expense.domain.model.Expense;
import com.sergioluigi.financialcontrol.expense.domain.model.PaymentMethod;

import java.time.LocalDate;
import java.util.UUID;

public record ExpenseResponseDTO(
        UUID id,
        Double value,
        LocalDate date,
        String description,
        boolean payed,
        UUID categoryId,
        PaymentMethod paymentMethod
) {
    public ExpenseResponseDTO(Expense expense) {
        this(expense.getId(),
            expense.getValue(),
            expense.getDate(),
            expense.getDescription(),
            expense.isPayed(),
            expense.getCategoryId(),
            expense.getPaymentMethod());
    }
}
