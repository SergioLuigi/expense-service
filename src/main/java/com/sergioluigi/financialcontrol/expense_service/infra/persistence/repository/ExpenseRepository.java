package com.sergioluigi.financialcontrol.expense_service.infra.persistence.repository;

import com.sergioluigi.financialcontrol.expense_service.infra.persistence.document.ExpenseDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ExpenseRepository extends MongoRepository<ExpenseDocument, String> {
}
