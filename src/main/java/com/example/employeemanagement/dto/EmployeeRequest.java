package com.example.employeemanagement.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmployeeRequest {
    @NotBlank(message = "name should not be empty")
    private String name;
    @NotBlank(message = "email should not be empty")
    private String email;
    private String department;
}
