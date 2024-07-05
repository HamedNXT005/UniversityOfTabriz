package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.Employee;
import com.example.universityoftabriz.Services.EmployeeService;
import com.example.universityoftabriz.Services.TeacherService;
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

    @RequestMapping("/AdminPanel/AdminManageEmployees")
    public String AdminPanel(Model model){

        return "AdminManageEmployees";
    }


    @GetMapping("/AdminPanel/AdminManageEmployees/LogOut")
    @ResponseBody
    public boolean Logout(){
        LoginController.uid = 100;
        return true;
    }

    @GetMapping("/AdminPanel/AdminManageEmployees/SeeEmployees")
    @ResponseBody
    public List<Employee> seeEmployees(){
        return employeeService.getAll();
    }
}
