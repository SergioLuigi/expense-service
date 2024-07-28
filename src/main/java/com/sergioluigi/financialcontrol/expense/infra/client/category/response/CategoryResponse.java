package com.sergioluigi.financialcontrol.expense.infra.client.category.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CategoryResponse {

    private UUID id;

    private String name;

    private String description;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;
}