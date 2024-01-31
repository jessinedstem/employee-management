package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.EmployeeResponse;
import com.example.employeemanagement.service.EmployeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
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
    public void findEmployeeById() throws Exception {
        long id = 1L;
        EmployeeResponse mockEmployeeResponse = EmployeeResponse.builder()
                .name("jessin")
                .email("raja.jessin@gmail.com")
                .department("student")
                .build();
        when(employeeService.findEmployeeById(id)).thenReturn(mockEmployeeResponse);
//        MockMvc.perform(get("employees/"+id))
//                .andExpect(jsonPath("$").isArray())
//                .andExpect(status.isOK());
//    }
    }
    @Test
    @DisplayName("Employee By Department")
    public void employeeByDepartment() throws Exception {

    }
}
