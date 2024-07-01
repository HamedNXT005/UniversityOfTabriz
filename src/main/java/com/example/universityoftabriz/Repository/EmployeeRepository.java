package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee , Long> {
}
