package com.sergioluigi.financialcontrol.expense.application.gateway;

import com.sergioluigi.financialcontrol.expense.domain.model.Expense;

import java.util.UUID;

public interface FindByIdExpenseRepositoryGateway {
    Expense execute(UUID id);
}
