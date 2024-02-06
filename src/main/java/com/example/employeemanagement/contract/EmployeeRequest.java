package com.example.employeemanagement.contract;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EmployeeRequest {
    @NotBlank(message = "name should not be empty")
    private String name;
    @NotBlank(message = "email should not be empty")
    private String email;
    @NotBlank(message = "department should not be empty")
    private String department;
}
