package com.example.MikhailDemo.service;

import com.example.MikhailDemo.dto.EmployeeDTO;
import com.example.MikhailDemo.entity.Employee;
import java.util.List;

public interface EmployeeService{

    Employee createEmployee(EmployeeDTO dto);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, EmployeeDTO dto);
    void deleteEmployee(Long id);
}