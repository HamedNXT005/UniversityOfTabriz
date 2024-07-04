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
public class TeacherPanelController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/TeacherPanel")
    public String TeacherPanel(Model model){
        Optional<Teacher> teacher = teacherService.getTeacherByID(LoginController.uid);
        Teacher teacher1 = teacher.get();

        String ImageUrl = teacher1.getPhoto();
        model.addAttribute("ImageURL" , ImageUrl);

        return "TeacherPanel";
    }

    @GetMapping("/TeacherPanel/getInfo")
    @ResponseBody
    public Optional<Teacher> getTeacherInfo(){
        Optional<Teacher> teacher = teacherService.getTeacherByID(LoginController.uid);
        return Optional.of(teacher.get());
    }

    @GetMapping("/TeacherPanel/LogOut")
    @ResponseBody
    public boolean Logout(){
        LoginController.uid = 100;
        return true;
    }
}
