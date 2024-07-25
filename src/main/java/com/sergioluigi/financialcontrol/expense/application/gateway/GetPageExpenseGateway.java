package com.sergioluigi.financialcontrol.expense.application.gateway;

import com.sergioluigi.financialcontrol.expense.domain.model.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetPageExpenseGateway {
    Page<Expense> execute(Pageable pageable);
}
