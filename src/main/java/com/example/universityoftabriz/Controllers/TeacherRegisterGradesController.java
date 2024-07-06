package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.*;
import com.example.universityoftabriz.Services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @Autowired
    private ComputerDefinedCoursesService computerDefinedCoursesService;
    @Autowired
    private CivilDefinedCoursesService civilDefinedCoursesService;
    @Autowired
    private ChemistryDefinedCoursesService chemistryDefinedCoursesService;
    @Autowired
    private ElectricDefinedCoursesService electricDefinedCoursesService;
    @Autowired
    private MechanicDefinedCoursesService mechanicDefinedCoursesService;


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

    @PostMapping("/TeacherPanel/TeacherRegisterGrades/submitGradeComputer")
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

    @PostMapping("/TeacherPanel/TeacherRegisterGrades/submitGradeChemistry")
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
    @PostMapping("/TeacherPanel/TeacherRegisterGrades/submitGradeCivil")
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
    @PostMapping("/TeacherPanel/TeacherRegisterGrades/submitGradeElectric")
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
    @PostMapping("/TeacherPanel/TeacherRegisterGrades/submitGradeMechanic")
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

    @GetMapping("/TeacherPanel/TeacherRegisterGrades/GetCompCourses")
    @ResponseBody
    public List<ComputerDefinedCourses> GetCompCourses(@RequestParam Long id){
        return computerDefinedCoursesService.getDCByTeacherId(id);
    }
    @GetMapping("/TeacherPanel/TeacherRegisterGrades/GetCivilCourses")
    @ResponseBody
    public List<CivilDefinedCourses> GetCivilCourses(@RequestParam Long id){
        return civilDefinedCoursesService.getDCByTeacherId(id);
    }
    @GetMapping("/TeacherPanel/TeacherRegisterGrades/GetCHCourses")
    @ResponseBody
    public List<ChemistryDefinedCourses> GetCHCourses(@RequestParam Long id){
        return chemistryDefinedCoursesService.getDCByTeacherId(id);
    }
    @GetMapping("/TeacherPanel/TeacherRegisterGrades/GetECourses")
    @ResponseBody
    public List<ElectricDefinedCourses> GetECourses(@RequestParam Long id){
        return electricDefinedCoursesService.getDCByTeacherId(id);
    }
    @GetMapping("/TeacherPanel/TeacherRegisterGrades/GetMCourses")
    @ResponseBody
    public List<MechanicDefinedCourses> GetMCourses(@RequestParam Long id){
        return mechanicDefinedCoursesService.getDCByTeacherId(id);
    }

    @GetMapping("/TeacherPanel/TeacherRegisterGrades/GetCompPlan")
    @ResponseBody
    public List<ComputerStudentsPlan> GetCompPlan(@RequestParam long id){
        return computerStudentsPlanService.getPlanByCourseId(id);
    }
    @GetMapping("/TeacherPanel/TeacherRegisterGrades/GetCivilPlan")
    @ResponseBody
    public List<CivilStudentsPlan> GetCivilPlan(@RequestParam long id){
        return civilStudentsPlanService.getPlanByCourseId(id);
    }
    @GetMapping("/TeacherPanel/TeacherRegisterGrades/GetCHPlan")
    @ResponseBody
    public List<ChemistryStudentsPlan> GetCHPlan(@RequestParam long id){
        return chemistryStudentsPlanService.getPlanByCourseId(id);
    }
    @GetMapping("/TeacherPanel/TeacherRegisterGrades/GetEPlan")
    @ResponseBody
    public List<ElectricStudentsPlan> GetEPlan(@RequestParam long id){
        return electricStudentsPlanService.getPlanByCourseId(id);
    }
    @GetMapping("/TeacherPanel/TeacherRegisterGrades/GetMPlan")
    @ResponseBody
    public List<MechanicStudentsPlan> GetMPlan(@RequestParam long id){
        return mechanicStudentsPlanService.getPlanByCourseId(id);
    }
}
