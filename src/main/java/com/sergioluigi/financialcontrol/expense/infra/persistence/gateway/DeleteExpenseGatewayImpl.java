package com.sergioluigi.financialcontrol.expense.infra.persistence.gateway;

import com.sergioluigi.financialcontrol.expense.application.gateway.DeleteExpenseGateway;
import com.sergioluigi.financialcontrol.expense.configuration.annotation.Gateway;
import com.sergioluigi.financialcontrol.expense.infra.persistence.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Gateway
@RequiredArgsConstructor
public class DeleteExpenseGatewayImpl implements DeleteExpenseGateway {

    private final ExpenseRepository expenseRepository;

    @Override
    public void execute(UUID id) {
        expenseRepository.deleteById(id);
    }
}
