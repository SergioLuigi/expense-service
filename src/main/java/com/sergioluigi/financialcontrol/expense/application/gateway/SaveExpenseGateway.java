package com.sergioluigi.financialcontrol.expense.application.gateway;

import com.sergioluigi.financialcontrol.expense.domain.model.Expense;

public interface SaveExpenseGateway {

    Expense execute(Expense expense);
}
