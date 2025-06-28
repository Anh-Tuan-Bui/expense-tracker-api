package com.example.expense_tracker.entity;

import com.example.expense_tracker.enumeration.ExpenseCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Expense {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String description;

    BigDecimal amount;

    @Enumerated(EnumType.STRING)
    ExpenseCategory category;

    @Temporal(TemporalType.DATE)
    Date expenseDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
