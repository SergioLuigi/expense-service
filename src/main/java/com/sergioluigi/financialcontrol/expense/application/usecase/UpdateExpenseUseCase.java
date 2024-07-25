package com.sergioluigi.financialcontrol.expense.application.usecase;

import com.sergioluigi.financialcontrol.expense.application.gateway.FindByIdExpenseGateway;
import com.sergioluigi.financialcontrol.expense.application.gateway.SaveExpenseGateway;
import com.sergioluigi.financialcontrol.expense.configuration.annotation.UseCase;
import com.sergioluigi.financialcontrol.expense.domain.model.Expense;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class UpdateExpenseUseCase {

    private final SaveExpenseGateway saveExpense;
    private final FindByIdExpenseGateway findExpenseById;

    @Transactional
    public Expense execute(UUID id, Expense updatedExpense) {
        /* TODO: MUST BE REFACTORED AFTER USER'S AUTHORIZATION/AUTHENTICATION IMPLEMENTATION */
        var currentExpense = findExpenseById.execute(id);
        return saveExpense.execute(
                currentExpense.updateWith(updatedExpense));
    }
}
