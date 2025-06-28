package com.example.expense_tracker.service;

import com.example.expense_tracker.dto.request.LoginRequest;
import com.example.expense_tracker.dto.request.SignupRequest;
import com.example.expense_tracker.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse login(LoginRequest request);
    String signup(SignupRequest request);
}
