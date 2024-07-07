package com.sergioluigi.financialcontrol.expense.application.gateway;

import com.sergioluigi.financialcontrol.expense.domain.Expense;

public interface SaveExpenseRepositoryGateway {

    Expense execute(Expense expense);
}
