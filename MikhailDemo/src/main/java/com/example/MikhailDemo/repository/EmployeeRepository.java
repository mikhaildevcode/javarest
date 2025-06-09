package com.example.MikhailDemo.repository;

import com.example.MikhailDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     * Finds all employees that belong to the given department.
     */
    List<Employee> findByDepartment(String department);
}

