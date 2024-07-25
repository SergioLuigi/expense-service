package com.sergioluigi.financialcontrol.expense.infra.controller;

import com.sergioluigi.financialcontrol.expense.application.usecase.*;
import com.sergioluigi.financialcontrol.expense.infra.controller.dto.ExpenseResponseDTO;
import com.sergioluigi.financialcontrol.expense.infra.controller.dto.SaveUpdateExpenseRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/expenses")
public class ExpenseController {

    private final CreateExpenseUseCase create;
    private final UpdateExpenseUseCase update;
    private final DeleteExpenseUseCase delete;
    private final FindByIdExpenseUseCase findById;
    private final GetPageExpenseUseCase getPage;

    @GetMapping
    @ResponseStatus(OK)
    public Page<ExpenseResponseDTO> getPage(@PageableDefault Pageable pageable) {
        return getPage.execute(pageable)
                .map(ExpenseResponseDTO::new);
    }

    @ResponseStatus(OK)
    @GetMapping("/{id}")
    public ExpenseResponseDTO findById(@PathVariable UUID id) {
        return new ExpenseResponseDTO(findById.execute(id));
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ExpenseResponseDTO create(@RequestBody @Valid SaveUpdateExpenseRequestDTO newExpense) {
        return new ExpenseResponseDTO(create.execute(newExpense.toExpense()));
    }

    @ResponseStatus(OK)
    @PutMapping("/{id}")
    public ExpenseResponseDTO update(@PathVariable UUID id,
                                     @RequestBody @Valid SaveUpdateExpenseRequestDTO updatedExpense) {
        return new ExpenseResponseDTO(update.execute(id, updatedExpense.toExpense()));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        delete.execute(id);
    }
}
