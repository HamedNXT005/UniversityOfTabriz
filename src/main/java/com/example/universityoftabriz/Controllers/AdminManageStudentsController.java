package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminManageStudentsController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/AdminPanel/AdminManageStudents")
    public String AdminPanel(Model model){

        return "AdminManageStudents";
    }


    @GetMapping("/AdminPanel/AdminManageStudents/LogOut")
    @ResponseBody
    public boolean Logout(){
        LoginController.uid = 100;
        return true;
    }
}
