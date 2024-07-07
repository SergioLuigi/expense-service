package com.sergioluigi.financialcontrol.expense.application.usecase;

import com.sergioluigi.financialcontrol.expense.application.gateway.SaveExpenseRepositoryGateway;
import com.sergioluigi.financialcontrol.expense.configuration.annotation.UseCase;
import com.sergioluigi.financialcontrol.expense.domain.Expense;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class CreateExpenseUseCase {

    private final SaveExpenseRepositoryGateway saveExpense;

    @Transactional
    public Expense execute(Expense newExpense) {
        return saveExpense.execute(newExpense);
    }
}
