package com.sergioluigi.financialcontrol.expense.application.usecase;

import com.sergioluigi.financialcontrol.expense.application.gateway.SaveExpenseGateway;
import com.sergioluigi.financialcontrol.expense.configuration.annotation.UseCase;
import com.sergioluigi.financialcontrol.expense.domain.model.Expense;
import com.sergioluigi.financialcontrol.expense.infra.client.category.CategoryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class CreateExpenseUseCase {

    private final SaveExpenseGateway saveExpense;
    private final CategoryClient categoryClient;

    @Transactional
    public Expense execute(Expense newExpense) {
        categoryClient.getCategoryById(newExpense.getCategoryId());
        return saveExpense.execute(newExpense);
    }
}
