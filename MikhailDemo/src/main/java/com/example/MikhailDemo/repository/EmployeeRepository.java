package com.example.MikhailDemo.repository;

import com.example.MikhailDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Additional query methods can be defined here if needed
    // For example, to find employees by department:
    // List<Employee> findByDepartment(String department);
}
