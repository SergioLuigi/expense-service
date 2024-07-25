package com.sergioluigi.financialcontrol.expense.application.gateway;

import java.util.UUID;

public interface DeleteExpenseGateway {
    void execute(UUID id);
}
