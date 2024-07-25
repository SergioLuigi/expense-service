package com.sergioluigi.financialcontrol.expense.application.usecase;

import com.sergioluigi.financialcontrol.expense.application.gateway.SaveExpenseGateway;
import com.sergioluigi.financialcontrol.expense.configuration.annotation.UseCase;
import com.sergioluigi.financialcontrol.expense.domain.model.Expense;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class CreateExpenseUseCase {

    private final SaveExpenseGateway saveExpense;

    @Transactional
    public Expense execute(Expense newExpense) {
        return saveExpense.execute(newExpense);
    }
}
