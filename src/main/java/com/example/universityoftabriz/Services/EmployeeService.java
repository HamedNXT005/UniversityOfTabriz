package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.Employee;
import com.example.universityoftabriz.Repository.EmployeeRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void updateEmployee(Employee employee, Logger logger) {
        employeeRepository.save(employee);
        logger.info("Employee with id: {} updated successfully.",employee.getId());
    }

    public Optional<Employee> getEmployeeByID(Long id){
        return employeeRepository.findById(id);
    }

    public Optional<Employee> getEmployeeByUserName(String userName){
        return employeeRepository.findByUserName(userName);
    }

    public Optional<Employee> getEmployeeByNameFAndNameL(String nameF, String nameL){
        return employeeRepository.findByNameFAndNameL(nameF, nameL);
    }

    public Optional<Employee> getEmployeeByNationalCode(String nationalCode){
        return employeeRepository.findByNationalCode(nationalCode);
    }

    public List<Employee> getEmployeesByDepartment(String department){
        return employeeRepository.findByDepartment(department);
    }

    public List<Employee> getEmployeesByDepartmentAndRole(String department, String role){
        return employeeRepository.findByDepartmentAndRole(department,role);
    }
}
