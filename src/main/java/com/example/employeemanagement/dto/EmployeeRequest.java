package com.example.employeemanagement.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class EmployeeRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String email;

    private String department;
}
