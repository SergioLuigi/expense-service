package com.sergioluigi.financialcontrol.expense_service.configuration;

import com.sergioluigi.financialcontrol.expense_service.infra.persistence.repository.ExpenseRepository;
import com.sergioluigi.financialcontrol.expense_service.usecase.CreateExpenseUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public CreateExpenseUseCase inject(ExpenseRepository expenseRepository) {
        return new CreateExpenseUseCase(expenseRepository);
    }
}
