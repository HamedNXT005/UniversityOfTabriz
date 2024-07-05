package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.Student;
import com.example.universityoftabriz.Services.StudentService;
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
public class AdminManageStudentsController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    private static final Logger logger = LoggerFactory.getLogger(AdminManageStudentsController.class);
    @RequestMapping("/AdminPanel/AdminManageStudents")
    public String AdminPanel(Model model){

        return "AdminManageStudents";
    }


    @GetMapping("/AdminPanel/AdminManageStudents/LogOut")
    @ResponseBody
    public boolean Logout(){
        LoginController.uid = 100;
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Admin has logged out.");
        MDC.clear();
        return true;
    }

    @GetMapping("/AdminPanel/AdminManageStudents/SeeStudents")
    @ResponseBody
    public List<Student> seeStudents(){
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("The list of all students has been sent to the front-end.");
        MDC.clear();
        return studentService.getAll();
    }
}
