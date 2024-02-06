package com.example.employeemanagement.service;

import com.example.employeemanagement.contract.EmployeeRequest;
import com.example.employeemanagement.contract.EmployeeResponse;
import com.example.employeemanagement.exception.EmployeeNotFoundException;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
public class EmployeeServiceTest {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private EmployeeService employeeService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        employeeRepository = mock(EmployeeRepository.class);
        modelMapper = mock(ModelMapper.class);
        employeeService = new EmployeeService(employeeRepository, modelMapper);
    }

    @Test
    public void testAddEmployee() {
        EmployeeRequest mockEmployeeRequest = EmployeeRequest.builder()
                .name("Jessin")
                .email("jessin@gmail.com")
                .department("EEE")
                .build();
        EmployeeResponse mockEmployeeResponse = EmployeeResponse.builder()
                .employeeId(1L)
                .name("Jessin")
                .email("jessin@gmail.com")
                .department("EEE")
                .build();
        Employee mockEmployee = Employee.builder()
                .employeeId(1L)
                .name("Jessin")
                .email("jessin@gmail.com")
                .department("EEE")
                .build();
        when(employeeRepository.save(any(Employee.class))).thenReturn(mockEmployee);
        when(modelMapper.map(mockEmployee, EmployeeResponse.class)).thenReturn(mockEmployeeResponse);
        EmployeeResponse actualResponse = employeeService.addEmployee(mockEmployeeRequest);
        assertEquals(mockEmployeeResponse, actualResponse);
    }

    @Test
    public void findEmployeeById() {
        Employee mockEmployee = Employee.builder()
                .employeeId(1L)
                .name("Jeevan")
                .email("jeev@gmail.com")
                .department("ECE")
                .build();
        EmployeeResponse mockEmployeeResponse = EmployeeResponse.builder()
                .employeeId(1L)
                .name("Jessin")
                .email("jessin@gmail.com")
                .department("EEE")
                .build();
        when(employeeRepository.findById(anyLong())).thenReturn(Optional.of(mockEmployee));
        when(modelMapper.map(mockEmployee, EmployeeResponse.class)).thenReturn(mockEmployeeResponse);
        EmployeeResponse actualEmployeeResponse = employeeService.findEmployeeById(1L);
        assertEquals(mockEmployeeResponse, actualEmployeeResponse);
    }

    @Test
    public void testGetEmployeesByDepartment() {
        List<Employee> mockEmployee = new ArrayList<>();
        Employee mockEmployee1 = Employee.builder()
                .employeeId(1L)
                .name("Grace")
                .department("EEE")
                .email("jessin@gmail.com")
                .build();
        Employee mockEmployee2=Employee.builder()
                .employeeId(1L)
                .name("Jessin")
                .department("EEE")
                .email("grace@gmail.com")
                .build();
        mockEmployee.add(mockEmployee1);
        mockEmployee.add(mockEmployee2);
        List<EmployeeResponse> mockEmployeeResponseList=new ArrayList<>();
        EmployeeResponse mockEmployeeResponseList1=EmployeeResponse.builder()
                .employeeId(1L)
                .name("Jessin")
                .email("jessin@gmail.com")
                .department("EEE")
                .build();
        EmployeeResponse mockEmployeeResponseList2=EmployeeResponse.builder()
                .employeeId(1L)
                .name("Jessi")
                .email("jessi@gmail.com")
                .department("EEE")
                .build();
        mockEmployeeResponseList.add(mockEmployeeResponseList1);
        mockEmployeeResponseList.add(mockEmployeeResponseList2);
        when(employeeRepository.findByDepartmentIgnoreCase("EEE")).thenReturn(mockEmployee);
//        when(mockEmployee.stream().map(mockEmp->modelMapper.map(mockEmp,EmployeeResponse.class)))
//                .thenReturn(List.of(mockEmployeeResponseList1,mockEmployeeResponseList2));
        List<EmployeeResponse> actualResponse=employeeService.getEmployeesByDepartment("EEE");
        assertEquals(2,actualResponse.size());
    }
    @Test
    public void testFindEmployeeById_throwsException() {
        Long employeeId=1L;
        when(employeeRepository.findById(anyLong())).thenReturn(Optional.empty());
    EmployeeNotFoundException exception = assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.findEmployeeById(1L);
        });

        assertEquals("Employee Not Found", exception.getMessage());
    }
}