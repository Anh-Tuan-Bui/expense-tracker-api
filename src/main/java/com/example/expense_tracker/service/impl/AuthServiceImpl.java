package com.example.expense_tracker.service.impl;

import com.example.expense_tracker.dto.request.LoginRequest;
import com.example.expense_tracker.dto.request.SignupRequest;
import com.example.expense_tracker.dto.response.AuthResponse;
import com.example.expense_tracker.entity.User;
import com.example.expense_tracker.enumeration.Role;
import com.example.expense_tracker.repository.UserRepository;
import com.example.expense_tracker.service.AuthService;
import com.example.expense_tracker.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        String token = jwtService.generateToken(request.getUsername());

        return new AuthResponse(token);
    }

    @Override
    public String signup(SignupRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            return "Username is already in use";
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setRole(Role.USER);

        userRepository.save(user);

        return "User registered successfully";
    }
}
