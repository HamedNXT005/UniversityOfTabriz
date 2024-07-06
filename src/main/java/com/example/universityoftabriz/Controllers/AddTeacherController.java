package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.Employee;
import com.example.universityoftabriz.Objects.Teacher;
import com.example.universityoftabriz.Services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import com.example.universityoftabriz.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AddTeacherController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private TeacherService teacherService;

    private static final Logger logger = LoggerFactory.getLogger(AddTeacherController.class);
    @RequestMapping("/EmployeePanel/AddTeacher")
    public String AddTeacher(Model model){
        Optional<Employee> employee = employeeService.getEmployeeByID(LoginController.uid);
        Employee employee1 = employee.get();
        String ImageUrl = employee1.getPhoto();
        model.addAttribute("ImageURL" , ImageUrl);
        return "AddTeacher";
    }

    @GetMapping("/EmployeePanel/AddTeacher/getInfo")
    @ResponseBody
    public Optional<Employee> getEmployeeInfo(){
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Employee's info with id: {} has been sent to the front-end",LoginController.uid);
        MDC.clear();
        return employeeService.getEmployeeByID(LoginController.uid);
    }

    @PostMapping("/EmployeePanel/AddTeacher/insertTeacher")
    @ResponseBody
    public void insertTeacher(@RequestBody Teacher teacher , @RequestParam String st){

        Teacher teacher1 = teacherService.getLastTeacher();

        System.out.println(teacher1.getId());

        teacher.setId(teacher1.getId() + 1);
        teacher.setStatus(st);
        teacherService.updateTeacher(teacher);
    }
}
