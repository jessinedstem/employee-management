package com.example.employeemanagement.service;

import com.example.employeemanagement.dto.EmployeeRequest;
import com.example.employeemanagement.dto.EmployeeResponse;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class EmployeeServiceTest {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private EmployeeService employeeService;
    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        employeeRepository= mock(EmployeeRepository.class);
        modelMapper=mock(ModelMapper.class);
        employeeService= new EmployeeService(employeeRepository,modelMapper);
    }
    @Test
    public void findEmployeeById(){
        List<Employee> mockEmployee=new ArrayList<>();
        when(employeeRepository.findById(id)).thenReturn(mockEmployee);

//    assertEquals();
//    verify()
    }

}
