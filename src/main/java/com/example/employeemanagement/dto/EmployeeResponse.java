package com.example.employeemanagement.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class EmployeeResponse {
    private long employeeId;
    private String name;
    private String email;
    private String department;
}
