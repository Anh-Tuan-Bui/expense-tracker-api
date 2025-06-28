package com.example.expense_tracker.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginRequest {

    @NotBlank(message = "username is not allowed to leave bank")
    private String username;

    @NotBlank(message = "password is not allowed to leave blank")
    private String password;
}
