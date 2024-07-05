package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.Employee;
import com.example.universityoftabriz.Objects.Student;
import com.example.universityoftabriz.Services.EmployeeService;
import com.example.universityoftabriz.Services.StudentService;
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
import java.util.Optional;

@Controller
public class StudentsListController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private StudentService studentService;
    private static final Logger logger = LoggerFactory.getLogger(StudentsListController.class);
    @RequestMapping("/EmployeePanel/StudentsList")
    public String StudentsList(Model model){
        Optional<Employee> employee = employeeService.getEmployeeByID(LoginController.uid);
        Employee employee1 = employee.get();
        String ImageUrl = employee1.getPhoto();
        model.addAttribute("ImageURL" , ImageUrl);
        return "StudentsList";
    }

    @GetMapping("/EmployeePanel/StudentsList/getInfo")
    @ResponseBody
    public Optional<Employee> getEmployeeInfo(){
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Employee's info with id: {} has been sent to the front-end",LoginController.uid);
        MDC.clear();
        return employeeService.getEmployeeByID(LoginController.uid);
    }

    @GetMapping("/EmployeePanel/StudentsList/getStudents")
    @ResponseBody
    public List<Student> GetStudents(){
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("A list of all students has been sent to the front-end.");
        MDC.clear();
        return studentService.getStudent();
    }

}
