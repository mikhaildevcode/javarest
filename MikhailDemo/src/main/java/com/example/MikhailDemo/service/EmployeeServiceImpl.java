package com.example.MikhailDemo.service;

import com.example.MikhailDemo.dto.EmployeeDTO;
import com.example.MikhailDemo.entity.Employee;
import com.example.MikhailDemo.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    @Override
    public Employee createEmployee (EmployeeDTO dto){
        return repo.save(Employee.builder()
                .name(dto.name())
                .department(dto.department())
                .email(dto.email())
                .build());
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Employee not found with id: " + id));
    }

    @Override
    public Employee updateEmployee(Long id, EmployeeDTO dto) {
        Employee emp = getEmployeeById(id);
        emp.setName(dto.name());
        emp.setDepartment(dto.department());
        emp.setEmail(dto.email());
        return repo.save(emp);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee emp = getEmployeeById(id);
        repo.delete(emp);
    }
}