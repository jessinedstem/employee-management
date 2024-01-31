package com.example.employeemanagement.service;

import com.example.employeemanagement.dto.EmployeeRequest;
import com.example.employeemanagement.dto.EmployeeResponse;
import com.example.employeemanagement.exception.EmployeeNotFoundException;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    @Autowired
            public EmployeeService(EmployeeRepository employeeRepository,ModelMapper modelMapper)
    {
        this.employeeRepository=employeeRepository;
        this.modelMapper=modelMapper;
    }

    public EmployeeResponse findEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee Not Found");
        }
        return modelMapper.map(employee, EmployeeResponse.class);
    }


    public List<EmployeeResponse> employeeByDepartment(String department) {
        List<Employee> employeeList=employeeRepository.findByDepartment(department);
        return employeeList.stream().map(employee -> modelMapper.map(employee,EmployeeResponse.class)
        ).collect(Collectors.toList());
    }

    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) {
        Employee employee= Employee.builder()
                .name(employeeRequest.getName())
                .email(employeeRequest.getEmail())
                .department(employeeRequest.getDepartment())
                .build();
        return modelMapper.map(employee,EmployeeResponse.class);
    }
}
