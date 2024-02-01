package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.EmployeeRequest;
import com.example.employeemanagement.dto.EmployeeResponse;
import com.example.employeemanagement.service.EmployeeService;
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

import static java.nio.file.Paths.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeService employeeService;

    @Test
    @DisplayName("Employee By Id")
    public void findEmployeeById() throws Exception {
        long id = 1L;
        EmployeeResponse mockEmployeeResponse = EmployeeResponse.builder()
                .name("jessin")
                .email("rajan.jessin@gmail.com")
                .department("student")
                .build();
        when(employeeService.findEmployeeById(id)).thenReturn(mockEmployeeResponse);
        MockMvc.perform(get("employees/"+id))
                .contentType(MediaType.APPLICATION_JSON)
                .andExpect(jsonPath("$").isArray())
                .andExpect(status().isOk());
    }
    @Test
    @DisplayName("Employee By Department")
    public void employeeByDepartment() throws Exception {
        List<EmployeeResponse> mockEmployeeResponse1= new ArrayList<>();
        EmployeeRequest employeeRequest=
                EmployeeRequest.builder()
                .name("Jeena")
                .email("jeenasusan123@gmail.com")
                .department("Malayalam")
                .build();
        when(employeeService.employeeByDepartment(department)).thenReturn(mockEmployeeResponse1);
        MockMvc.perform(get("employees"))
                .contentType(MediaType.APPLICATION_JSON)
                .andExpect(jsonPath("$").isArray())
                .andExpect(status().isOk());
    }
    @Test
    @DisplayName("Add Employee")
    public void addEmployee() throws Exception{
        EmployeeRequest request=EmployeeRequest.builder()
                .name("Jeen")
                .email("jerryp12@gmail.com")
                .department("Arts")
                .build();
        EmployeeResponse response1=EmployeeResponse.builder()
                .name("Jeen")
                .email("jerryp12@gmail.com")
                .department("Arts")
                .build();
        when(employeeService.addEmployee()).thenReturn(response1);
        MockMvc.perform(post("employees"))
                .contentType(MediaType.APPLICATION_JSON)
                .andExpect(jsonPath("$").isArray())
                .andExpect(status().isOk());
    }
}
