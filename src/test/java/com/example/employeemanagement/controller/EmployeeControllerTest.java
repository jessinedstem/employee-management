package com.example.employeemanagement.controller;

import com.example.employeemanagement.contract.EmployeeRequest;
import com.example.employeemanagement.contract.EmployeeResponse;
import com.example.employeemanagement.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeService employeeService;

    @Test
    @DisplayName("Add Employee")
    public void addEmployee() throws Exception {
        EmployeeRequest request = EmployeeRequest.builder()
                .name("Jeen")
                .email("jerryp12@gmail.com")
                .department("Arts")
                .build();
        EmployeeResponse response1 = EmployeeResponse.builder()
                .employeeId(1L)
                .name("Jeen")
                .email("jerryp12@gmail.com")
                .department("Arts")
                .build();
        when(employeeService.addEmployee(any(EmployeeRequest.class))).thenReturn(response1);
        mockMvc.perform(post("/employee/add-employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isCreated());
    }
    @Test
    @DisplayName("Employee By Id")
    public void testFindEmployeeById() throws Exception {
        Long id = 1L;
        EmployeeResponse mockEmployeeResponse = EmployeeResponse.builder()
                .employeeId(id)
                .name("jessin")
                .email("rajan.jessin@gmail.com")
                .department("student")
                .build();
        when(employeeService.findEmployeeById(anyLong())).thenReturn(mockEmployeeResponse);
            mockMvc.perform(get("/employee/"+id))
                    .andExpect(status().isOk());
    }
    @Test
    @DisplayName("Employee By Department")
    public void testGetEmployeesByDepartment() throws Exception {
        String mockDepartment="Malayalam";
        List<EmployeeResponse> mockEmployeeResponseList= new ArrayList<>();
        EmployeeResponse mockEmployeeResponse = EmployeeResponse.builder()
                .employeeId(1L)
                .name("jessin")
                .email("rajan.jessin@gmail.com")
                .department(mockDepartment)
                .build();
        mockEmployeeResponseList.add(mockEmployeeResponse);
        when(employeeService.getEmployeesByDepartment(mockDepartment)).thenReturn(mockEmployeeResponseList);
        mockMvc.perform(get("/employee/get-byDepartment")
                .param("department",mockDepartment)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
