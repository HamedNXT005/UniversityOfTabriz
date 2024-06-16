package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.Student;
import com.example.universityoftabriz.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private StudentService studentService;
    @RequestMapping("/")
    public String Login(){
        return "Login";
    }

    @GetMapping("/api/getStudents")
    @ResponseBody
    public List<Student> getAllStudents(){
        return studentService.getStudent();
    }
}
