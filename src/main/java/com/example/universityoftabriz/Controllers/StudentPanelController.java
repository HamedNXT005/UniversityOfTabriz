package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.*;
import com.example.universityoftabriz.Services.*;
import com.example.universityoftabriz.Services.HistoryOfPassedCourses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentPanelController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private CoursesService coursesService;
    @Autowired
    private ComputerStudentsPlanService computerStudentsPlanService;
    @Autowired
    private ComputerHistoryOfPassedCoursesService computerHistoryOfPassedCoursesService;
    @Autowired
    private CivilStudentsPlanService civilStudentsPlanService;
    @Autowired
    private CivilHistoryOfPassedCoursesService civilHistoryOfPassedCoursesService;
    @Autowired
    private ChemistryStudentsPlanService chemistryStudentsPlanService;
    @Autowired
    private ChemistryHistoryOfPassedCoursesService chemistryHistoryOfPassedCoursesService;
    @Autowired
    private ElectricStudentsPlanService electricStudentsPlanService;
    @Autowired
    private ElectricHistoryOfPassedCoursesService electricHistoryOfPassedCoursesService;
    @Autowired
    private MechanicStudentsPlanService mechanicStudentsPlanService;
    @Autowired
    private MechanicHistoryOfPassedCoursesService mechanicHistoryOfPassedCoursesService;
    private static final Logger logger = LoggerFactory.getLogger(StudentPanelController.class);
    @RequestMapping("/StudentPanel")
    public String StudentPanel(Model model){
        Optional<Student> student = studentService.getStudentById(LoginController.uid);
        Student student1 = student.get();
        float semesterGPA = 0;
        float totalGPA = 0;
        if (student1.getFaculty().equals("computer")){
            semesterGPA = getGPASemester(student1.getId(),computerStudentsPlanService,coursesService);
            totalGPA = getGPATotal(student1.getId(),computerHistoryOfPassedCoursesService,coursesService);
        } else if (student1.getFaculty().equals("civil")){
            semesterGPA = getGPASemester(student1.getId(),civilStudentsPlanService,coursesService);
            totalGPA = getGPATotal(student1.getId(),civilHistoryOfPassedCoursesService,coursesService);
        } else if (student1.getFaculty().equals("chemistry")){
            semesterGPA = getGPASemester(student1.getId(),chemistryStudentsPlanService,coursesService);
            totalGPA = getGPATotal(student1.getId(),chemistryHistoryOfPassedCoursesService,coursesService);
        } else if (student1.getFaculty().equals("electric")){
            semesterGPA = getGPASemester(student1.getId(),electricStudentsPlanService,coursesService);
            totalGPA = getGPATotal(student1.getId(),electricHistoryOfPassedCoursesService,coursesService);
        } else if (student1.getFaculty().equals("mechanic")){
            semesterGPA = getGPASemester(student1.getId(),mechanicStudentsPlanService,coursesService);
            totalGPA = getGPATotal(student1.getId(),mechanicHistoryOfPassedCoursesService,coursesService);
        }
        if (semesterGPA!=0) {
            student1.setGpaSemester(semesterGPA);
            student1.setGpaTotal(totalGPA);
        }
        studentService.updateStudent(student1);
        String ImageUrl = student1.getPhoto();
        model.addAttribute("ImageURL" , ImageUrl);

        return "StudentPanel";
    }


    @GetMapping("/StudentPanel/getInfo")
    @ResponseBody
    public Optional<Student> getStudentInfo(){
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Student's info with id: {} has been sent to the front-end",LoginController.uid);
        MDC.clear();
        return studentService.getStudentById(LoginController.uid);
    }

    @GetMapping("/StudentPanel/LogOut")
    @ResponseBody
    public boolean Logout(){
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Student has logged out.");
        MDC.clear();
        LoginController.uid = 100;
        return true;
    }

    private static <T extends StudentsPlanService<E>,E extends StudentPlan> float getGPASemester(long id, T facultyService,CoursesService coursesService){
        List<E> studentsPlan = facultyService.getPlanByStudentId(id);
        Iterator<E> iterator = studentsPlan.iterator();
        float gradesSum = 0;
        int totalUnits = 0;
        while (iterator.hasNext()){
            E studentPlan = iterator.next();
            Courses course = coursesService.getById(studentPlan.getCourseId()).get();
            if (studentPlan.getGrade()!=0) {
                gradesSum += (studentPlan.getGrade()*course.getUnitN());
                totalUnits+=course.getUnitN();
            }
        }
        if (totalUnits!=0)
            return gradesSum/totalUnits;
        else
            return 0;
    }

    private static <T extends HistoryOfPassedCourses<E>,E extends com.example.universityoftabriz.Objects.HistoryOfPassedCourses> float getGPATotal(long id, T facultyService, CoursesService coursesService){
        List<E> historyOfPassedCourses = facultyService.getHistoryOfPCByStudentId(id);
        Iterator<E> iterator = historyOfPassedCourses.iterator();
        float gradesSum = 0;
        int totalUnits = 0;
        while (iterator.hasNext()){
            E historyOfPassedCourse = iterator.next();
            Courses course = coursesService.getById(historyOfPassedCourse.getCourseId()).get();
            if (historyOfPassedCourse.getGrade()!=0) {
                gradesSum += (historyOfPassedCourse.getGrade()*course.getUnitN());
                totalUnits+=course.getUnitN();
            }
        }
        if (totalUnits!=0)
            return gradesSum/totalUnits;
        else
            return 0;
    }
}
