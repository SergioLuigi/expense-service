package com.sergioluigi.financialcontrol.expense.infra.client.category;

import com.sergioluigi.financialcontrol.expense.infra.client.category.response.CategoryResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.UUID;

public interface CategoryClient {

    @GetExchange("/categories/{id}")
    CategoryResponse getCategoryById(@PathVariable UUID id);
}
