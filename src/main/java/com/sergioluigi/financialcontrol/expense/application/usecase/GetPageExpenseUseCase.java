package com.sergioluigi.financialcontrol.expense.application.usecase;

import com.sergioluigi.financialcontrol.expense.application.gateway.GetPageExpenseGateway;
import com.sergioluigi.financialcontrol.expense.domain.model.Expense;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPageExpenseUseCase {

    private final GetPageExpenseGateway getPageExpenseGateway;

    public Page<Expense> execute(Pageable pageable) {
        return getPageExpenseGateway.execute(pageable);
    }
}
