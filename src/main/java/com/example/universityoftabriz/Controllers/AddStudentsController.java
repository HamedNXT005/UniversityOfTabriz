package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.Employee;
import com.example.universityoftabriz.Objects.Student;
import com.example.universityoftabriz.Objects.Teacher;
import com.example.universityoftabriz.Services.EmployeeService;
import com.example.universityoftabriz.Services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AddStudentsController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private StudentService studentService;

    private static final Logger logger = LoggerFactory.getLogger(AddStudentsController.class);
    @RequestMapping("/EmployeePanel/AddStudent")
    public String AddStudent(Model model){
        Optional<Employee> employee = employeeService.getEmployeeByID(LoginController.uid);
        Employee employee1 = employee.get();
        String ImageUrl = employee1.getPhoto();
        model.addAttribute("ImageURL" , ImageUrl);
        return "AddStudent";
    }

    @GetMapping("/EmployeePanel/AddStudent/getInfo")
    @ResponseBody
    public Optional<Employee> getEmployeeInfo(){
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Employee's info with id: {} has been sent to the front-end",LoginController.uid);
        MDC.clear();
        return employeeService.getEmployeeByID(LoginController.uid);
    }

    @PostMapping("/EmployeePanel/AddStudent/AddNewStudent")
    @ResponseBody
    public void AddNewStudent(@RequestBody Student student){

        Student student1 = studentService.getLastStudent();
        student.setId(student1.getId() + 1);
        studentService.updateStudent(student);
    }
}
