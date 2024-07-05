package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.Student;
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

import java.util.Optional;

@Controller
public class StudentPanelController {

    @Autowired
    private StudentService studentService;
    private static final Logger logger = LoggerFactory.getLogger(StudentPanelController.class);
    @RequestMapping("/StudentPanel")
    public String StudentPanel(Model model){
        Optional<Student> student = studentService.getStudentById(LoginController.uid);
        Student student1 = student.get();

        String ImageUrl = student1.getPhoto();
        model.addAttribute("ImageURL" , ImageUrl);

        return "StudentPanel";
    }


    @GetMapping("/StudentPanel/getInfo")
    @ResponseBody
    public Optional<Student> getStudentInfo(){
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Student's info with id: {} has been sent to the front-end",LoginController.uid);
        MDC.clear();
        return studentService.getStudentById(LoginController.uid);
    }

    @GetMapping("/StudentPanel/LogOut")
    @ResponseBody
    public boolean Logout(){
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Student has logged out.");
        MDC.clear();
        LoginController.uid = 100;
        return true;
    }
}
