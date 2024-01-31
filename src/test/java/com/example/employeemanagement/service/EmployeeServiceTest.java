package com.example.employeemanagement.service;

import com.example.employeemanagement.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;

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

}
