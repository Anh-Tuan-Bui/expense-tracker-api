package com.example.expense_tracker.dto.response;

import com.example.expense_tracker.enumeration.ExpenseCategory;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpenseResponse {
    Long id;
    String description;
    BigDecimal amount;
    ExpenseCategory category;
    Date expenseDate;
}
