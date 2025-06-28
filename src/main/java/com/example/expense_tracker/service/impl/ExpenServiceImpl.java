package com.example.expense_tracker.service.impl;

import com.example.expense_tracker.dto.request.ExpenseRequest;
import com.example.expense_tracker.dto.response.ExpenseResponse;
import com.example.expense_tracker.entity.Expense;
import com.example.expense_tracker.entity.User;
import com.example.expense_tracker.exception.NotFoundException;
import com.example.expense_tracker.repository.ExpenseRepository;
import com.example.expense_tracker.repository.UserRepository;
import com.example.expense_tracker.service.ExpenseService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExpenServiceImpl implements ExpenseService {

    ExpenseRepository expenseRepository;
    UserRepository userRepository;
    ModelMapper mapper;

    @Override
    public ExpenseResponse createExpense(Long userId, ExpenseRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));

        Expense expense = Expense.builder()
                .description(request.getDescription())
                .amount(request.getAmount())
                .category(request.getCategory())
                .expenseDate(request.getExpenseDate())
                .user(user)
                .build();

        Expense savedExpense = expenseRepository.save(expense);

        return mapper.map(savedExpense, ExpenseResponse.class);
    }

    @Override
    public ExpenseResponse updateExpense(Long userId, Long expenseId, ExpenseRequest expenseRequest) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new NotFoundException("Expense not found"));

        if (!expense.getUser().getId().equals(userId)) {
            throw new RuntimeException("Unauthorized access");
        }

        expense.setDescription(expenseRequest.getDescription());
        expense.setAmount(expenseRequest.getAmount());
        expense.setCategory(expenseRequest.getCategory());
        expense.setExpenseDate(expenseRequest.getExpenseDate());

        Expense updatedExpense = expenseRepository.save(expense);

        return mapper.map(updatedExpense, ExpenseResponse.class);
    }

    @Override
    public void deleteExpense(Long userId, Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new NotFoundException("Expense not found"));

        if (!expense.getUser().getId().equals(userId)) {
            throw new RuntimeException("Unauthorized access");
        }

        expenseRepository.delete(expense);
    }

    @Override
    public List<ExpenseResponse> getExpenses(Long userId, Date startDate, Date endDate) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));

        List<Expense> expenses = expenseRepository.findByUserAndExpenseDateBetween(user, startDate, endDate);

        return expenses.stream()
                .map(expense -> mapper.map(expense, ExpenseResponse.class))
                .toList();
    }
}
