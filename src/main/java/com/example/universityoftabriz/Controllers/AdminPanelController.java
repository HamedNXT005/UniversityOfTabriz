package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.Teacher;
import com.example.universityoftabriz.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class AdminPanelController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/AdminPanel")
    public String AdminPanel(Model model){

        return "AdminPanel";
    }


    @GetMapping("/AdminPanel/LogOut")
    @ResponseBody
    public boolean Logout(){
        LoginController.uid = 100;
        return true;
    }
}
