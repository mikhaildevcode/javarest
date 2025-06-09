package com.example.MikhailDemo.controller;

import com.example.MikhailDemo.dto.EmployeeDTO;
import com.example.MikhailDemo.entity.Employee;
import com.example.MikhailDemo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public Employee create(@Valid @RequestBody EmployeeDTO dto) {
        return service.createEmployee(dto);
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @GetMapping("/department/{department}")
    public List<Employee> getByDepartment(@PathVariable String department) {
        return service.getEmployeesByDepartment(department);
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @Valid @RequestBody EmployeeDTO dto) {
        return service.updateEmployee(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteEmployee(id);
    }
}

