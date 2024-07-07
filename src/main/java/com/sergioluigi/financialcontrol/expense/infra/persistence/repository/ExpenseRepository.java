package com.sergioluigi.financialcontrol.expense.infra.persistence.repository;

import com.sergioluigi.financialcontrol.expense.infra.persistence.entity.ExpensePersistence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExpenseRepository extends JpaRepository<ExpensePersistence, UUID> {}
