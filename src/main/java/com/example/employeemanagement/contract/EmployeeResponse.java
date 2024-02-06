package com.example.employeemanagement.contract;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class EmployeeResponse {
    private long employeeId;
    private String name;
    private String email;
    private String department;
}
