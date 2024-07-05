package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.Employee;
import com.example.universityoftabriz.Services.EmployeeService;
import com.example.universityoftabriz.Services.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdminManageEmployeesController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private EmployeeService employeeService;
    private static final Logger logger = LoggerFactory.getLogger(AdminManageEmployeesController.class);
    @RequestMapping("/AdminPanel/AdminManageEmployees")
    public String AdminPanel(Model model){

        return "AdminManageEmployees";
    }


    @GetMapping("/AdminPanel/AdminManageEmployees/LogOut")
    @ResponseBody
    public boolean Logout(){
        LoginController.uid = 100;
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Admin has logged out.");
        MDC.clear();
        return true;
    }

    @GetMapping("/AdminPanel/AdminManageEmployees/SeeEmployees")
    @ResponseBody
    public List<Employee> seeEmployees(){
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("The list of all employees has been sent to the front-end.");
        MDC.clear();
        return employeeService.getAll();
    }
}
