package com.example.expense_tracker.controller;

import com.example.expense_tracker.dto.request.ExpenseRequest;
import com.example.expense_tracker.dto.response.ExpenseResponse;
import com.example.expense_tracker.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService service;

    @GetMapping
    public List<ExpenseResponse> getExpenses(
            @RequestParam Long userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate
    ) {
        return service.getExpenses(userId, startDate, endDate);
    }

    @PostMapping
    public ExpenseResponse createExpense(
            @RequestParam Long userId,
            @RequestBody ExpenseRequest request
    ) {
        return service.createExpense(userId, request);
    }

    @PutMapping("/{id}")
    public ExpenseResponse updateExpense(
            @RequestParam Long userId,
            @PathVariable Long id,
            @RequestBody ExpenseRequest request
    ) {
        return service.updateExpense(userId, id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(
            @RequestParam Long userId,
            @PathVariable Long id
    ) {
        service.deleteExpense(userId, id);

        return ResponseEntity.noContent().build();
    }
}
