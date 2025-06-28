package com.example.expense_tracker.service;

import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

public interface JwtService {

    String SECRET_KEY = "12345678901234567890123456789012";

    default SecretKey getSignKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    String generateToken(String username);
    String extractUsername(String token);
    boolean isTokenValid(String token, String username);
    boolean isTokenExpired(String token);
}
