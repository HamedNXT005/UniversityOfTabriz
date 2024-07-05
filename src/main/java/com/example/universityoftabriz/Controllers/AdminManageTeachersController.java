package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.Teacher;
import com.example.universityoftabriz.Services.TeacherService;
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

    @RequestMapping("/AdminPanel/AminManageTeachers")
    public String AdminPanel(Model model){

        return "AdminManageTeachers";
    }


    @GetMapping("/AdminPanel/AdminManageTeachers/LogOut")
    @ResponseBody
    public boolean Logout(){
        LoginController.uid = 100;
        return true;
    }

    @GetMapping("/AminPanel/AdminManageTeachers/SeeTeachers")
    @ResponseBody
    public List<Teacher> seeTeachers(){
        return teacherService.getAll();
    }
}
