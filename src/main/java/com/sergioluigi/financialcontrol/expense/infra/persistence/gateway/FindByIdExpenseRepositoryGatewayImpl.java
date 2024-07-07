package com.sergioluigi.financialcontrol.expense.infra.persistence.gateway;

import com.sergioluigi.financialcontrol.expense.application.gateway.FindByIdExpenseRepositoryGateway;
import com.sergioluigi.financialcontrol.expense.configuration.annotation.Gateway;
import com.sergioluigi.financialcontrol.expense.domain.exception.ExpenseNotFoundException;
import com.sergioluigi.financialcontrol.expense.domain.model.Expense;
import com.sergioluigi.financialcontrol.expense.infra.persistence.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Gateway
@RequiredArgsConstructor
public class FindByIdExpenseRepositoryGatewayImpl
        implements FindByIdExpenseRepositoryGateway {

    private final ExpenseRepository repository;

    public Expense execute(UUID id) {
        return repository.findById(id)
                .orElseThrow(ExpenseNotFoundException::new)
                .toExpense();
    }
}
