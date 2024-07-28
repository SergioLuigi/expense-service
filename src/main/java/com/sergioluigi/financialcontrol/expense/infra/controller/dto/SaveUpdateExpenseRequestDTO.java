package com.sergioluigi.financialcontrol.expense.infra.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sergioluigi.financialcontrol.expense.domain.model.Expense;
import com.sergioluigi.financialcontrol.expense.domain.model.PaymentMethod;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public record SaveUpdateExpenseRequestDTO(
        @NotNull
        Double value,
        @NotNull
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate date,
        @NotNull
        @Size(min = 3, max = 240)
        String description,
        boolean payed,
        @NotNull
        UUID categoryId,
        @NotNull
        PaymentMethod paymentMethod
) {

    public Expense toExpense() {
        return Expense.builder()
                .date(date)
                .value(value)
                .description(description)
                .payed(payed)
                .categoryId(categoryId)
                .paymentMethod(paymentMethod)
                .build();
    }
}
