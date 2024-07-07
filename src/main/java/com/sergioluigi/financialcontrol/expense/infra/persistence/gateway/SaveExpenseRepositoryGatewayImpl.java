package com.sergioluigi.financialcontrol.expense.infra.persistence.gateway;

import com.sergioluigi.financialcontrol.expense.application.gateway.SaveExpenseRepositoryGateway;
import com.sergioluigi.financialcontrol.expense.configuration.annotation.Gateway;
import com.sergioluigi.financialcontrol.expense.domain.Expense;
import com.sergioluigi.financialcontrol.expense.infra.persistence.entity.ExpensePersistence;
import com.sergioluigi.financialcontrol.expense.infra.persistence.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;

@Gateway
@RequiredArgsConstructor
public class SaveExpenseRepositoryGatewayImpl implements SaveExpenseRepositoryGateway {

    private final ExpenseRepository repository;

    @Override
    public Expense execute(Expense expense) {
        return repository.save(ExpensePersistence.of(expense)).toExpense();
    }
}
