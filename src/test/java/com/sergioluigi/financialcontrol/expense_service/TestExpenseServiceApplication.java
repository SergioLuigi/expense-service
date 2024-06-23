package com.sergioluigi.financialcontrol.expense_service;

import org.springframework.boot.SpringApplication;

public class TestExpenseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(ExpenseServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
