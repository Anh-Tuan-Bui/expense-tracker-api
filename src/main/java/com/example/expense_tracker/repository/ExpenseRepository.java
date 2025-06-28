package com.example.expense_tracker.repository;

import com.example.expense_tracker.entity.Expense;
import com.example.expense_tracker.entity.User;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUserAndExpenseDateBetween(User user, Date start, Date end);
}
