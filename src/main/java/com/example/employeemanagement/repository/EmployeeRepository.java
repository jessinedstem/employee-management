package com.example.employeemanagement.repository;

import com.example.employeemanagement.model.Employee;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long>{
    List<Employee> findByDepartment(String departmentName);

}
