package com.example.employeemanagement.contract.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EmployeeRequest {
    @NotBlank(message = "name should not be empty")
    private String name;

    @NotBlank(message = "email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "department should not be empty")
    private String department;
}
