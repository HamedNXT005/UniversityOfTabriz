package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.Employee;
import com.example.universityoftabriz.Services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class ManageDefinedCoursesController {
    @Autowired
    private EmployeeService employeeService;
    private static final Logger logger = LoggerFactory.getLogger(ManageDefinedCoursesController.class);
    @RequestMapping("/EmployeePanel/ManageDefinedCourses")
    public String ManageDefinedCourses(Model model){
        Optional<Employee> employee = employeeService.getEmployeeByID(LoginController.uid);
        Employee employee1 = employee.get();
        String ImageUrl = employee1.getPhoto();
        model.addAttribute("ImageURL" , ImageUrl);
        return "ManageDefinedCourses";
    }

    @GetMapping("/EmployeePanel/ManageDefinedCourses/getInfo")
    @ResponseBody
    public Optional<Employee> getEmployeeInfo(){
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Employee's info with id: {} has been sent to the front-end",LoginController.uid);
        MDC.clear();
        return employeeService.getEmployeeByID(LoginController.uid);
    }
}
