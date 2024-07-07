package com.sergioluigi.financialcontrol.expense.infra.persistence.entity;

import com.sergioluigi.financialcontrol.expense.domain.model.Expense;
import com.sergioluigi.financialcontrol.expense.domain.model.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@Table(name = "expense")
@EntityListeners(AuditingEntityListener.class)
public class ExpensePersistence {

    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private Double value;

    @Column(nullable = false)
    private LocalDate date;

    @Column(length = 240)
    private String description;

    @Column
    private boolean payed;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    public ExpensePersistence(){}

    public static ExpensePersistence of(Expense expense) {
        return new ExpensePersistence(expense.getId(),
                expense.getValue(),
                expense.getDate(),
                expense.getDescription(),
                expense.isPayed(),
                expense.getPaymentMethod(),
                expense.getCreatedDate(),
                expense.getModifiedDate());
    }

    public Expense toExpense() {
        return Expense.builder()
                        .id(id)
                        .date(date)
                        .value(value)
                        .description(description)
                        .payed(payed)
                        .paymentMethod(paymentMethod)
                        .createdDate(createdDate)
                        .modifiedDate(modifiedDate)
                        .build();
    }
}
