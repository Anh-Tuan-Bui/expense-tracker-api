package com.example.expense_tracker.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class SignupRequest {
    @NotBlank(message = "Username is not allowed to leave blank")
    private String username;

    @NotBlank(message = "password is not allowed to leave blank")
    private String password;

    @NotBlank(message = "Email is not allowed to leave blank")
    private String email;
}
