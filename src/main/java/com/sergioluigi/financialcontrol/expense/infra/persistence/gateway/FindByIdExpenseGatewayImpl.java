package com.sergioluigi.financialcontrol.expense.infra.persistence.gateway;

import com.sergioluigi.financialcontrol.expense.application.gateway.FindByIdExpenseGateway;
import com.sergioluigi.financialcontrol.expense.configuration.annotation.Gateway;
import com.sergioluigi.financialcontrol.expense.domain.exception.ExpenseNotFoundException;
import com.sergioluigi.financialcontrol.expense.domain.model.Expense;
import com.sergioluigi.financialcontrol.expense.infra.persistence.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Gateway
@RequiredArgsConstructor
public class FindByIdExpenseGatewayImpl
        implements FindByIdExpenseGateway {

    private final ExpenseRepository repository;

    public Expense execute(UUID id) {
        return repository.findById(id)
                .orElseThrow(ExpenseNotFoundException::new)
                .toExpense();
    }
}
