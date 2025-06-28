package com.example.expense_tracker.dto.request;

import com.example.expense_tracker.enumeration.ExpenseCategory;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpenseRequest {

    @NotBlank(message = "Description is not allowed to leave blank")
    String description;

    @NotBlank(message = "Amount is not allowed to leave blank")
    BigDecimal amount;

    ExpenseCategory category;
    Date expenseDate;
}
