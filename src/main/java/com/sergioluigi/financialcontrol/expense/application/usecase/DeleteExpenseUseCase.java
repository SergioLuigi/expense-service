package com.sergioluigi.financialcontrol.expense.application.usecase;

import com.sergioluigi.financialcontrol.expense.application.gateway.DeleteExpenseGateway;
import com.sergioluigi.financialcontrol.expense.configuration.annotation.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class DeleteExpenseUseCase {

    private final DeleteExpenseGateway deleteExpenseGateway;

    @Transactional
    public void execute(UUID id) {
        //TODO: MUST CHANGE WHEN AUTHORIZATION AND AUTHENTICATION ARE IMPLEMENTED
        deleteExpenseGateway.execute(id);
    }

}
