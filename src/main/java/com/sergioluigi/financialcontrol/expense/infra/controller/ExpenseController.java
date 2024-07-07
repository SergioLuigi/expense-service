package com.sergioluigi.financialcontrol.expense.infra.controller;

import com.sergioluigi.financialcontrol.expense.application.usecase.UpdateExpenseUseCase;
import com.sergioluigi.financialcontrol.expense.infra.controller.dto.SaveUpdateExpenseRequestDTO;
import com.sergioluigi.financialcontrol.expense.infra.controller.dto.NewExpenseResponseDTO;
import com.sergioluigi.financialcontrol.expense.application.usecase.CreateExpenseUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/expenses")
public class ExpenseController {

    private final CreateExpenseUseCase createExpense;
    private final UpdateExpenseUseCase updateExpense;

    @PostMapping
    @ResponseStatus(CREATED)
    public NewExpenseResponseDTO create(@RequestBody @Valid SaveUpdateExpenseRequestDTO newExpense) {
        return new NewExpenseResponseDTO(createExpense.execute(newExpense.toExpense()));
    }

    @ResponseStatus(OK)
    @PutMapping("/{id}")
    public NewExpenseResponseDTO update(@PathVariable UUID id,
                                        @RequestBody @Valid SaveUpdateExpenseRequestDTO updatedExpense) {
        return new NewExpenseResponseDTO(updateExpense.execute(id, updatedExpense.toExpense()));
    }
}
