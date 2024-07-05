package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.Teacher;
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
public class AdminManageTeachersController {
    @Autowired
    private TeacherService teacherService;
    private static final Logger logger = LoggerFactory.getLogger(AdminManageTeachersController.class);
    @RequestMapping("/AdminPanel/AdminManageTeachers")
    public String AdminPanel(Model model){

        return "AdminManageTeachers";
    }


    @GetMapping("/AdminPanel/AdminManageTeachers/LogOut")
    @ResponseBody
    public boolean Logout(){
        LoginController.uid = 100;
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Admin has logged out.");
        MDC.clear();
        return true;
    }

    @GetMapping("/AminPanel/AdminManageTeachers/SeeTeachers")
    @ResponseBody
    public List<Teacher> seeTeachers(){
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("The list of all teachers has been sent to the front-end.");
        MDC.clear();
        return teacherService.getAll();
    }
}
