package com.sergioluigi.financialcontrol.expense.infra.controller;

import com.sergioluigi.financialcontrol.expense.infra.controller.dto.NewExpenseRequestDTO;
import com.sergioluigi.financialcontrol.expense.infra.controller.dto.NewExpenseResponseDTO;
import com.sergioluigi.financialcontrol.expense.application.usecase.CreateExpenseUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import static org.springframework.http.HttpStatus.CREATED;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/expenses")
public class ExpenseController {

    private final CreateExpenseUseCase createExpense;

    @PostMapping
    @ResponseStatus(CREATED)
    public NewExpenseResponseDTO create(@RequestBody @Valid NewExpenseRequestDTO newExpense) {
        return new NewExpenseResponseDTO(createExpense.execute(newExpense.toExpense()));
    }
}
