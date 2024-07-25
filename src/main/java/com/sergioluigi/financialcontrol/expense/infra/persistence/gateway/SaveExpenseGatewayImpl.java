package com.sergioluigi.financialcontrol.expense.infra.persistence.gateway;

import com.sergioluigi.financialcontrol.expense.application.gateway.SaveExpenseGateway;
import com.sergioluigi.financialcontrol.expense.configuration.annotation.Gateway;
import com.sergioluigi.financialcontrol.expense.domain.model.Expense;
import com.sergioluigi.financialcontrol.expense.infra.persistence.entity.ExpensePersistence;
import com.sergioluigi.financialcontrol.expense.infra.persistence.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;

@Gateway
@RequiredArgsConstructor
public class SaveExpenseGatewayImpl implements SaveExpenseGateway {

    private final ExpenseRepository repository;

    @Override
    public Expense execute(Expense expense) {
       return repository.save(ExpensePersistence.of(expense)).toExpense();
    }
}
