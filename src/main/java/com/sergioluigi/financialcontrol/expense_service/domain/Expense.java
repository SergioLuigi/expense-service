package com.sergioluigi.financialcontrol.expense_service.domain;

import java.time.LocalDate;

public class Expense {

    private final Double value;

    private final LocalDate date;

    private final String description;

    private final boolean payed;

    public Expense(Double value,
            LocalDate date,
            String description,
            boolean payed) {
        this.value = value;
        this.date = date;
        this.description = description;
        this.payed = payed;
    }

    public Double getValue() {
        return value;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPayed() {
        return payed;
    }
}
