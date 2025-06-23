package com.ardadev.mitocodeexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ardadev.mitocodeexample.models.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Employee findByUsername(String username);
}
