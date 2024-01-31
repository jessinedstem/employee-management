package com.example.employeemanagement.employeeController;

import com.example.employeemanagement.dto.EmployeeRequest;
import com.example.employeemanagement.dto.EmployeeResponse;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

 @GetMapping("employees/{id}")
    public ResponseEntity<EmployeeResponse> employeeById(@PathVariable long id){
        EmployeeResponse employeeResponses=employeeService.findEmployeeById(id);
        return ResponseEntity.ok(employeeResponses);

    }
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeResponse>> employeeByDepartment(@RequestParam String department){
        List<EmployeeResponse> responses=employeeService.employeeByDepartment(department);
        return ResponseEntity.ok(responses);
    }

@PostMapping("/employees")
    public ResponseEntity<EmployeeResponse> addEmployee(@Valid @RequestBody EmployeeRequest employeeRequest){
    EmployeeResponse response=employeeService.addEmployee(employeeRequest);
   return ResponseEntity.status(HttpStatus.CREATED).body(response);
}
}
