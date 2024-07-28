package com.sergioluigi.financialcontrol.expense.infra.persistence.gateway;

import com.sergioluigi.financialcontrol.expense.application.gateway.GetPageExpenseGateway;
import com.sergioluigi.financialcontrol.expense.domain.model.Expense;
import com.sergioluigi.financialcontrol.expense.infra.persistence.entity.ExpensePersistence;
import com.sergioluigi.financialcontrol.expense.infra.persistence.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GetPageExpenseGatewayImpl implements GetPageExpenseGateway {

    private final ExpenseRepository repository;

    @Override
    public Page<Expense> execute(Pageable pageable) {
        return repository.findAll(pageable)
                .map(ExpensePersistence::toExpense);
    }

}
