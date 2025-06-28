package com.example.expense_tracker.service;

import com.example.expense_tracker.dto.request.ExpenseRequest;
import com.example.expense_tracker.dto.response.ExpenseResponse;

import java.util.Date;
import java.util.List;

public interface ExpenseService {
    ExpenseResponse createExpense(Long userId, ExpenseRequest expenseRequest);
    ExpenseResponse updateExpense(Long userId, Long expenseId, ExpenseRequest expenseRequest);
    void deleteExpense(Long userId, Long expenseId);
    List<ExpenseResponse> getExpenses(Long userId, Date startDate, Date endDate);
}
