package com.example.employeemanagement.service;

import com.example.employeemanagement.contract.request.EmployeeRequest;
import com.example.employeemanagement.contract.response.EmployeeResponse;
import com.example.employeemanagement.exception.EmployeeNotFoundException;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) {
        Employee employee =
                Employee.builder()
                        .name(employeeRequest.getName())
                        .email(employeeRequest.getEmail().toLowerCase().trim())
                        .department(employeeRequest.getDepartment().toLowerCase().trim())
                        .build();
        Employee saved = employeeRepository.save(employee);
        return modelMapper.map(saved, EmployeeResponse.class);
    }

    public EmployeeResponse findEmployeeById(Long employeeId) {
        Employee employee =
                employeeRepository
                        .findById(employeeId)
                        .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found"));
        return modelMapper.map(employee, EmployeeResponse.class);
    }

    public List<EmployeeResponse> getEmployeesByDepartment(String department) {
        List<Employee> employeeList = employeeRepository.findByDepartmentIgnoreCase(department);
        if(employeeList.isEmpty()){
            throw new EmployeeNotFoundException("No employees in this department");
        }else {

            return employeeList.stream()
                    .map(employee -> modelMapper.map(employee, EmployeeResponse.class))
                    .collect(Collectors.toList());
        }
    }
}
