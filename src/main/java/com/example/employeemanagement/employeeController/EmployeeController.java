package com.example.employeemanagement.employeeController;

import com.example.employeemanagement.contract.EmployeeRequest;
import com.example.employeemanagement.contract.EmployeeResponse;
import com.example.employeemanagement.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add-employee")
    public ResponseEntity<EmployeeResponse> addNewEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
        EmployeeResponse response = employeeService.addEmployee(employeeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponse> findEmployeeById(@PathVariable Long employeeId) {
        EmployeeResponse response = employeeService.findEmployeeById(employeeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-byDepartment")
    public ResponseEntity<List<EmployeeResponse>> getEmployeesByDepartment(@RequestParam String department) {
        List<EmployeeResponse> responses=employeeService.getEmployeesByDepartment(department);
        return ResponseEntity.ok(responses);
    }
}
