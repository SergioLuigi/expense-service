package com.sergioluigi.financialcontrol.expense.application.usecase;

import com.sergioluigi.financialcontrol.expense.application.gateway.FindByIdExpenseGateway;
import com.sergioluigi.financialcontrol.expense.configuration.annotation.UseCase;
import com.sergioluigi.financialcontrol.expense.domain.model.Expense;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class FindByIdExpenseUseCase {

    private final FindByIdExpenseGateway findByIdExpenseGateway;

    public Expense execute(UUID id) {
        return findByIdExpenseGateway.execute(id);
    }
}
