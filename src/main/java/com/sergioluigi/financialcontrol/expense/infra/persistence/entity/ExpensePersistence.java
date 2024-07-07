package com.sergioluigi.financialcontrol.expense.infra.persistence.entity;

import com.sergioluigi.financialcontrol.expense.domain.Expense;
import com.sergioluigi.financialcontrol.expense.domain.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
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
    private final Double value;

    @Column(nullable = false)
    private final LocalDate date;

    @Column(length = 240)
    private final String description;

    @Column
    private final boolean payed;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private final PaymentMethod paymentMethod;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    public static ExpensePersistence of(Expense expense) {
        return new ExpensePersistence(null,
                expense.getValue(),
                expense.getDate(),
                expense.getDescription(),
                expense.isPayed(),
                expense.getPaymentMethod(),
                null,
                null);
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
