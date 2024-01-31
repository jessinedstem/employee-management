package com.example.employeemanagement.employeeController;

import com.example.employeemanagement.dto.EmployeeRequest;
import com.example.employeemanagement.dto.EmployeeResponse;
import com.example.employeemanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    private final EmployeeService employeeService() {
     @Autowired
    this.employeeService();
    }
 @GetMapping("/id")
    public ResponseEntity<EmployeeResponse> employeeById(@PathVariable long EmployeeId){
        EmployeeResponse employeeResponses=employeeService.findEmployeeById();
        return ResponseEntity.ok(employeeResponses);

    }
    @GetMapping("/employee/department")
    public ResponseEntity<List<EmployeeResponse>> employeeByDepartment()

@PostMapping()
}
