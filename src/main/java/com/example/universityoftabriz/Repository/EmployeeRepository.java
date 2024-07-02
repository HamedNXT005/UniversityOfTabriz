package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee , Long> {

    Optional<Employee> findByNameFAndNameL(String nameF, String nameL);

    Optional<Employee> findByNationalCode(String nationalCode);

    List<Employee> findByDepartment(String department);

    List<Employee> findByDepartmentAndRole(String department, String role);
}
