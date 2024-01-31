package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.EmployeeResponse;
import com.example.employeemanagement.service.EmployeeService;
import jakarta.persistence.Id;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import javax.net.ssl.SSLEngineResult;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Paths.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeService employeeService;

    @Test
    @DisplayName("Employee By Id")
    public void employeeById() throws Exception {
        long id = 1L;
        List<EmployeeResponse> mockEmployeeResponse = new ArrayList<>();
        when employeeService.findEmployeeById(Id).thenReturn(mockEmployeeResponse);
        MockMvc.perform(get("employee/id"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(status.isOK());
    }
    @Test
    @DisplayName("Employee By Department")
    public void employeeByDepartment() throws Exception {

    }
}
