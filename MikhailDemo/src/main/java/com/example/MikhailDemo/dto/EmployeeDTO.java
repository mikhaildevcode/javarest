package com.example.MikhailDemo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmployeeDTO(
        @NotBlank(message = "Name cannot be blank")
        String name,

        @NotBlank(message = "Department cannot be blank")
        String department,

        @Email(message = "Email should be valid")
        @NotBlank(message = "Email cannot be blank")
        String email
) {}
