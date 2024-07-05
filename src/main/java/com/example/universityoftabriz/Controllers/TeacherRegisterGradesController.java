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

import java.util.Optional;

@Controller
public class TeacherRegisterGradesController {
    private static final Logger logger = LoggerFactory.getLogger(TeacherRegisterGradesController.class);
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ComputerStudentsPlanService computerStudentsPlanService;
    @Autowired
    private ComputerHistoryOfPassedCoursesService computerHistoryOfPassedCoursesService;
    @Autowired
    private ChemistryStudentsPlanService chemistryStudentsPlanService;
    @Autowired
    private ChemistryHistoryOfPassedCoursesService chemistryHistoryOfPassedCoursesService;
    @Autowired
    private CivilStudentsPlanService civilStudentsPlanService;
    @Autowired
    private CivilHistoryOfPassedCoursesService civilHistoryOfPassedCoursesService;
    @Autowired
    private ElectricStudentsPlanService electricStudentsPlanService;
    @Autowired
    private ElectricHistoryOfPassedCoursesService electricHistoryOfPassedCoursesService;
    @Autowired
    private MechanicStudentsPlanService mechanicStudentsPlanService;
    @Autowired
    private MechanicHistoryOfPassedCoursesService mechanicHistoryOfPassedCoursesService;
    @RequestMapping("/TeacherPanel/TeacherRegisterGrades")
    public String StudentsList(Model model){
        Optional<Teacher> teacher = teacherService.getTeacherByID(LoginController.uid);
        Teacher teacher1 = teacher.get();

        String ImageUrl = teacher1.getPhoto();
        model.addAttribute("ImageURL" , ImageUrl);
        return "TeacherRegisterGrades";
    }

    @GetMapping("/TeacherPanel/TeacherRegisterGrades/getInfo")
    @ResponseBody
    public Optional<Teacher> getTeacherInfo(){
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Teacher's info with id: {} has been sent to the front-end",LoginController.uid);
        MDC.clear();
        return teacherService.getTeacherByID(LoginController.uid);
    }

    @GetMapping("/TeacherPanel/TeacherRegisterGrades/submitGradeComputer")
    @ResponseBody
    public void submitGradeComputer(@RequestParam long studentId,@RequestParam long courseId,@RequestParam float grade){
        MDC.put("uid",String.valueOf(LoginController.uid));
        ComputerStudentsPlan studentsPlan = computerStudentsPlanService.getPlanByStudentIdAndCourseId(studentId,courseId).get();
        studentsPlan.setGrade(grade);
        computerStudentsPlanService.updateComputerStudentsPlan(studentsPlan);
        ComputerHistoryOfPassedCourses historyOfPassedCourses = new ComputerHistoryOfPassedCourses();
        ComputerHistoryOfPassedCourses lastHistory = computerHistoryOfPassedCoursesService.findLastRecord();
        historyOfPassedCourses.setId(lastHistory.getId()+1);
        historyOfPassedCourses.setStudentId(studentId);
        historyOfPassedCourses.setCourseId(courseId);
        historyOfPassedCourses.setGrade(grade);
        historyOfPassedCourses.setStatus(grade >= 10f);
        computerHistoryOfPassedCoursesService.updateComputerHistoryOfPassedCourses(historyOfPassedCourses);
        logger.info("Grade submitted successfully for the Student with id: {} and Course with id: {} .",studentId,courseId);
        MDC.clear();
    }

    @GetMapping("/TeacherPanel/TeacherRegisterGrades/submitGradeChemistry")
    @ResponseBody
    public void submitGradeChemistry(@RequestParam long studentId,@RequestParam long courseId,@RequestParam float grade){
        MDC.put("uid",String.valueOf(LoginController.uid));
        ChemistryStudentsPlan studentsPlan = chemistryStudentsPlanService.getPlanByStudentIdAndCourseId(studentId,courseId).get();
        studentsPlan.setGrade(grade);
        chemistryStudentsPlanService.updateChemistryStudentsPlan(studentsPlan);
        ChemistryHistoryOfPassedCourses historyOfPassedCourses = new ChemistryHistoryOfPassedCourses();
        ChemistryHistoryOfPassedCourses lastHistory = chemistryHistoryOfPassedCoursesService.findLastRecord();
        historyOfPassedCourses.setId(lastHistory.getId()+1);
        historyOfPassedCourses.setStudentId(studentId);
        historyOfPassedCourses.setCourseId(courseId);
        historyOfPassedCourses.setGrade(grade);
        historyOfPassedCourses.setStatus(grade >= 10f);
        chemistryHistoryOfPassedCoursesService.updateChemistryHistoryOfPassedCourses(historyOfPassedCourses);
        logger.info("Grade submitted successfully for the Student with id: {} and Course with id: {} .",studentId,courseId);
        MDC.clear();
    }
    @GetMapping("/TeacherPanel/TeacherRegisterGrades/submitGradeCivil")
    @ResponseBody
    public void submitGradeCivil(@RequestParam long studentId,@RequestParam long courseId,@RequestParam float grade){
        MDC.put("uid",String.valueOf(LoginController.uid));
        CivilStudentsPlan studentsPlan = civilStudentsPlanService.getPlanByStudentIdAndCourseId(studentId,courseId).get();
        studentsPlan.setGrade(grade);
        civilStudentsPlanService.updateCivilStudentsPlan(studentsPlan);
        CivilHistoryOfPassedCourses historyOfPassedCourses = new CivilHistoryOfPassedCourses();
        CivilHistoryOfPassedCourses lastHistory = civilHistoryOfPassedCoursesService.findLastRecord();
        historyOfPassedCourses.setId(lastHistory.getId()+1);
        historyOfPassedCourses.setStudentId(studentId);
        historyOfPassedCourses.setCourseId(courseId);
        historyOfPassedCourses.setGrade(grade);
        historyOfPassedCourses.setStatus(grade >= 10f);
        civilHistoryOfPassedCoursesService.updateCivilHistoryOfPassedCourses(historyOfPassedCourses);
        logger.info("Grade submitted successfully for the Student with id: {} and Course with id: {} .",studentId,courseId);
        MDC.clear();
    }
    @GetMapping("/TeacherPanel/TeacherRegisterGrades/submitGradeElectric")
    @ResponseBody
    public void submitGradeElectric(@RequestParam long studentId,@RequestParam long courseId,@RequestParam float grade){
        MDC.put("uid",String.valueOf(LoginController.uid));
        ElectricStudentsPlan studentsPlan = electricStudentsPlanService.getPlanByStudentIdAndCourseId(studentId,courseId).get();
        studentsPlan.setGrade(grade);
        electricStudentsPlanService.updateElectricStudentsPlan(studentsPlan);
        ElectricHistoryOfPassedCourses historyOfPassedCourses = new ElectricHistoryOfPassedCourses();
        ElectricHistoryOfPassedCourses lastHistory = electricHistoryOfPassedCoursesService.findLastRecord();
        historyOfPassedCourses.setId(lastHistory.getId()+1);
        historyOfPassedCourses.setStudentId(studentId);
        historyOfPassedCourses.setCourseId(courseId);
        historyOfPassedCourses.setGrade(grade);
        historyOfPassedCourses.setStatus(grade >= 10f);
        electricHistoryOfPassedCoursesService.updateElectricHistoryOfPassedCourses(historyOfPassedCourses);
        logger.info("Grade submitted successfully for the Student with id: {} and Course with id: {} .",studentId,courseId);
        MDC.clear();
    }
    @GetMapping("/TeacherPanel/TeacherRegisterGrades/submitGradeMechanic")
    @ResponseBody
    public void submitGradeMechanic(@RequestParam long studentId,@RequestParam long courseId,@RequestParam float grade){
        MDC.put("uid",String.valueOf(LoginController.uid));
        MechanicStudentsPlan studentsPlan = mechanicStudentsPlanService.getPlanByStudentIdAndCourseId(studentId,courseId).get();
        studentsPlan.setGrade(grade);
        mechanicStudentsPlanService.updateMechanicStudentsPlan(studentsPlan);
        MechanicHistoryOfPassedCourses historyOfPassedCourses = new MechanicHistoryOfPassedCourses();
        MechanicHistoryOfPassedCourses lastHistory = mechanicHistoryOfPassedCoursesService.findLastRecord();
        historyOfPassedCourses.setId(lastHistory.getId()+1);
        historyOfPassedCourses.setStudentId(studentId);
        historyOfPassedCourses.setCourseId(courseId);
        historyOfPassedCourses.setGrade(grade);
        historyOfPassedCourses.setStatus(grade >= 10f);
        mechanicHistoryOfPassedCoursesService.updateMechanicHistoryOfPassedCourses(historyOfPassedCourses);
        logger.info("Grade submitted successfully for the Student with id: {} and Course with id: {} .",studentId,courseId);
        MDC.clear();
    }

}
