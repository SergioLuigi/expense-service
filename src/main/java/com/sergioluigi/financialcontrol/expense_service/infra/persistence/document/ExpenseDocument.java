package com.sergioluigi.financialcontrol.expense_service.infra.persistence.document;

import com.sergioluigi.financialcontrol.expense_service.domain.Expense;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@Document("expense")
public class ExpenseDocument {

    @Id
    private String id;

    private Double value;

    private LocalDate date;

    private String description;

    private boolean payed;

    public static ExpenseDocument of(Expense expense) {
        return new ExpenseDocument(UUID.randomUUID().toString(), expense.getValue(), expense.getDate(),
                expense.getDescription(), expense.isPayed());
    }

    public Expense toExpense() {
        return new Expense(value, date, description, false);
    }

}
