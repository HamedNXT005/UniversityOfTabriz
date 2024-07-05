package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.SemesterPhase;
import com.example.universityoftabriz.Objects.Teacher;
import com.example.universityoftabriz.Services.SemesterPhaseService;
import com.example.universityoftabriz.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminSelectPhaseController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private SemesterPhaseService semesterPhaseService;

    @RequestMapping("/AdminPanel/AdminSelectPhase")
    public String AdminPanel(Model model){

        return "AdminSelectPhase";
    }


    @GetMapping("/AdminPanel/AdminSelectPhase/LogOut")
    @ResponseBody
    public boolean Logout(){
        LoginController.uid = 100;
        return true;
    }

    @GetMapping("/AdminPanel/AdminSelectPhase/SeePhases")
    @ResponseBody
    public List<SemesterPhase> seePhases(){
        return semesterPhaseService.getAll();
    }

    @GetMapping("/AdminPanel/AdminSelectPhase/UpdatePhase")
    @ResponseBody
    public void updatePhase(@RequestParam long id){
        List<SemesterPhase> semesterPhases = semesterPhaseService.getAll();
        for (SemesterPhase semesterPhase : semesterPhases) {
            if (semesterPhase.getId() == id) {
                semesterPhase.setStatus(true);
            } else {
                semesterPhase.setStatus(false);
            }
        }
        for (SemesterPhase semesterPhase : semesterPhases){
            semesterPhaseService.updateSemesterPhase(semesterPhase);
        }
    }
}
