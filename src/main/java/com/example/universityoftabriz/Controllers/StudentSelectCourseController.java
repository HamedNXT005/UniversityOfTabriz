package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.Student;
import com.example.universityoftabriz.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class StudentSelectCourseController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/StudentPanel/StudentSelectCourse")
    public String StudentCoursesList(Model model) {
        Optional<Student> student = studentService.getStudentById(LoginController.uid);
        Student student1 = student.get();

        String ImageUrl = student1.getPhoto();
        model.addAttribute("ImageURL" , ImageUrl);

        return "StudentSelectCourse";
    }

    @GetMapping("/StudentPanel/StudentSelectCourse/getInfo")
    @ResponseBody
    public Optional<Student> getEmployeeInfo(){
        Optional<Student> student = studentService.getStudentById(LoginController.uid);
        return Optional.of(student.get());
    }

}
