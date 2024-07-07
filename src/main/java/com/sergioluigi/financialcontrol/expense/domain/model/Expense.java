package com.sergioluigi.financialcontrol.expense.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
public class Expense {

    private final UUID id;

    private final Double value;

    private final LocalDate date;

    private final String description;

    private final boolean payed;

    private final PaymentMethod paymentMethod;

    private final LocalDateTime createdDate;

    private final LocalDateTime modifiedDate;

    private Expense(UUID id,
                    Double value,
                    LocalDate date,
                    String description,
                    boolean payed,
                    PaymentMethod paymentMethod,
                    LocalDateTime createdDate,
                    LocalDateTime modifiedDate) {
        this.id = id;
        this.value = value;
        this.date = date;
        this.description = description;
        this.payed = payed;
        this.paymentMethod = paymentMethod;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Expense updateWith(Expense expense) {
        return new Expense(this.id,
                expense.value, expense.date,
                expense.description, expense.payed,
                expense.paymentMethod, this.createdDate, this.modifiedDate);
    }
}
