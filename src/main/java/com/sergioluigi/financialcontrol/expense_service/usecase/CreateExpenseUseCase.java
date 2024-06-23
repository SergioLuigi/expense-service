package com.sergioluigi.financialcontrol.expense_service.usecase;

import com.sergioluigi.financialcontrol.expense_service.domain.Expense;
import com.sergioluigi.financialcontrol.expense_service.infra.persistence.document.ExpenseDocument;
import com.sergioluigi.financialcontrol.expense_service.infra.persistence.repository.ExpenseRepository;

public class CreateExpenseUseCase {

    private final ExpenseRepository expenseRepository;

    public CreateExpenseUseCase(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense execute(Expense newExpense) {
        var newExpenseDocument = ExpenseDocument.of(newExpense);
        return expenseRepository.save(newExpenseDocument).toExpense();
    }
}
