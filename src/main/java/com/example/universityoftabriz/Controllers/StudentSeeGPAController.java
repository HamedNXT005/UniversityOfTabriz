package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.*;
import com.example.universityoftabriz.Services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentSeeGPAController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ComputerStudentsPlanService computerStudentsPlanService;
    @Autowired
    private CivilStudentsPlanService civilStudentsPlanService;
    @Autowired
    private ChemistryStudentsPlanService chemistryStudentsPlanService;
    @Autowired
    private ElectricStudentsPlanService electricStudentsPlanService;
    @Autowired
    private MechanicStudentsPlanService mechanicStudentsPlanService;
    @Autowired
    private CoursesService coursesService;

    private static final Logger logger = LoggerFactory.getLogger(StudentSeeGPAController.class);
    @RequestMapping("/StudentPanel/StudentSeeGPA")
    public String StudentCoursesList(Model model) {
        Optional<Student> student = studentService.getStudentById(LoginController.uid);
        Student student1 = student.get();

        String ImageUrl = student1.getPhoto();
        model.addAttribute("ImageURL" , ImageUrl);

        return "StudentSeeGPA";
    }

    @GetMapping("/StudentPanel/StudentSeeGPA/getInfo")
    @ResponseBody
    public Optional<Student> getEmployeeInfo(){
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Student's info with id: {} has been sent to the front-end",LoginController.uid);
        MDC.clear();
        return studentService.getStudentById(LoginController.uid);
    }

    @GetMapping("/StudentPanel/StudentSeeGPA/getCompCourses")
    @ResponseBody
    public List<ComputerStudentsPlan> getCompCourses(@RequestParam long id){
        return computerStudentsPlanService.getPlanByStudentId(id);
    }
    @GetMapping("/StudentPanel/StudentSeeGPA/getCivilCourses")
    @ResponseBody
    public List<CivilStudentsPlan> getCivilCourses(@RequestParam long id){
        return civilStudentsPlanService.getPlanByStudentId(id);
    }
    @GetMapping("/StudentPanel/StudentSeeGPA/getECourses")
    @ResponseBody
    public List<ElectricStudentsPlan> getECourses(@RequestParam long id){
        return electricStudentsPlanService.getPlanByStudentId(id);
    }
    @GetMapping("/StudentPanel/StudentSeeGPA/getChCourses")
    @ResponseBody
    public List<ChemistryStudentsPlan> getChCourses(@RequestParam long id){
        return chemistryStudentsPlanService.getPlanByStudentId(id);
    }
    @GetMapping("/StudentPanel/StudentSeeGPA/getMCourses")
    @ResponseBody
    public List<MechanicStudentsPlan> getMCourses(@RequestParam long id){
        return mechanicStudentsPlanService.getPlanByStudentId(id);
    }

    @GetMapping("/StudentPanel/StudentSeeGPA/GetCourse")
    @ResponseBody
    public Optional<Courses> getCourse(@RequestParam long id){
        return coursesService.getById(id);
    }











}
