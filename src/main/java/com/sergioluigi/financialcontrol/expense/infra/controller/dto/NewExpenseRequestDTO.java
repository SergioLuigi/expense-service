package com.sergioluigi.financialcontrol.expense.infra.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sergioluigi.financialcontrol.expense.domain.Expense;
import com.sergioluigi.financialcontrol.expense.domain.PaymentMethod;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record NewExpenseRequestDTO(
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
        PaymentMethod paymentMethod
) {

    public Expense toExpense() {
        return Expense.builder()
                .date(date)
                .value(value)
                .description(description)
                .payed(payed)
                .paymentMethod(paymentMethod)
                .build();
    }
}
