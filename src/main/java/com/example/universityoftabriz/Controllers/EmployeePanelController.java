package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Services.EmployeeService;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeePanelController {
    @Autowired
    private EmployeeService employeeService;

}
