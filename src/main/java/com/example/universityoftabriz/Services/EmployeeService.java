package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.Employee;
import com.example.universityoftabriz.Objects.HistorySalary;
import com.example.universityoftabriz.Repository.EmployeeRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void updateEmployee(Employee employee, Logger logger) {
        employeeRepository.save(employee);
        logger.info("Employee with id: {} updated successfully.",employee.getId());
    }
}
