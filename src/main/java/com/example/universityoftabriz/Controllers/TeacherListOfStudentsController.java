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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
public class TeacherListOfStudentsController {
    private static final Logger logger = LoggerFactory.getLogger(TeacherListOfStudentsController.class);
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ComputerStudentsPlanService computerStudentsPlanService;
    @Autowired
    private ChemistryStudentsPlanService chemistryStudentsPlanService;
    @Autowired
    private CivilStudentsPlanService civilStudentsPlanService;
    @Autowired
    private ElectricStudentsPlanService electricStudentsPlanService;
    @Autowired
    private MechanicStudentsPlanService mechanicStudentsPlanService;

    @RequestMapping("/TeacherPanel/TeacherListOfStudents")
    public String StudentsList(Model model){
        Optional<Teacher> teacher = teacherService.getTeacherByID(LoginController.uid);
        Teacher teacher1 = teacher.get();

        String ImageUrl = teacher1.getPhoto();
        model.addAttribute("ImageURL" , ImageUrl);
        return "TeacherListOfStudents";
    }

    @GetMapping("/TeacherPanel/TeacherListOfStudents/getInfo")
    @ResponseBody
    public Optional<Teacher> getTeacherInfo(){
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Teacher's info with id: {} has been sent to the front-end",LoginController.uid);
        MDC.clear();
        return teacherService.getTeacherByID(LoginController.uid);
    }

    @GetMapping("/TeacherPanel/TeacherListOfStudents/showComputer")
    @ResponseBody
    public List<Student> showComputer(@RequestParam long courseId){
        MDC.put("uid",String.valueOf(LoginController.uid));
        List<Student> list = new ArrayList<>();
        List<ComputerStudentsPlan> planList = computerStudentsPlanService.getPlanByCourseId(courseId);
        Iterator<ComputerStudentsPlan> iterator = planList.iterator();
        while (iterator.hasNext()){
            ComputerStudentsPlan plan = iterator.next();
            list.add(studentService.getStudentById(plan.getStudentId()).get());
        }
        logger.info("List of students of the class with id: {} has been sent to the front-end successfully.",courseId);
        MDC.clear();
        return list;
    }

    @GetMapping("/TeacherPanel/TeacherListOfStudents/showChemistry")
    @ResponseBody
    public List<Student> showChemistry(@RequestParam long courseId){
        MDC.put("uid",String.valueOf(LoginController.uid));
        List<Student> list = new ArrayList<>();
        List<ChemistryStudentsPlan> planList = chemistryStudentsPlanService.getPlanByCourseId(courseId);
        Iterator<ChemistryStudentsPlan> iterator = planList.iterator();
        while (iterator.hasNext()){
            ChemistryStudentsPlan plan = iterator.next();
            list.add(studentService.getStudentById(plan.getStudentId()).get());
        }
        logger.info("List of students of the class with id: {} has been sent to the front-end successfully.",courseId);
        MDC.clear();
        return list;
    }

    @GetMapping("/TeacherPanel/TeacherListOfStudents/showCivil")
    @ResponseBody
    public List<Student> showCivil(@RequestParam long courseId){
        MDC.put("uid",String.valueOf(LoginController.uid));
        List<Student> list = new ArrayList<>();
        List<CivilStudentsPlan> planList = civilStudentsPlanService.getPlanByCourseId(courseId);
        Iterator<CivilStudentsPlan> iterator = planList.iterator();
        while (iterator.hasNext()){
            CivilStudentsPlan plan = iterator.next();
            list.add(studentService.getStudentById(plan.getStudentId()).get());
        }
        logger.info("List of students of the class with id: {} has been sent to the front-end successfully.",courseId);
        MDC.clear();
        return list;
    }

    @GetMapping("/TeacherPanel/TeacherListOfStudents/showElectric")
    @ResponseBody
    public List<Student> showElectric(@RequestParam long courseId){
        MDC.put("uid",String.valueOf(LoginController.uid));
        List<Student> list = new ArrayList<>();
        List<ElectricStudentsPlan> planList = electricStudentsPlanService.getPlanByCourseId(courseId);
        Iterator<ElectricStudentsPlan> iterator = planList.iterator();
        while (iterator.hasNext()){
            ElectricStudentsPlan plan = iterator.next();
            list.add(studentService.getStudentById(plan.getStudentId()).get());
        }
        logger.info("List of students of the class with id: {} has been sent to the front-end successfully.",courseId);
        MDC.clear();
        return list;
    }

    @GetMapping("/TeacherPanel/TeacherListOfStudents/showMechanic")
    @ResponseBody
    public List<Student> showMechanic(@RequestParam long courseId){
        MDC.put("uid",String.valueOf(LoginController.uid));
        List<Student> list = new ArrayList<>();
        List<MechanicStudentsPlan> planList = mechanicStudentsPlanService.getPlanByCourseId(courseId);
        Iterator<MechanicStudentsPlan> iterator = planList.iterator();
        while (iterator.hasNext()){
            MechanicStudentsPlan plan = iterator.next();
            list.add(studentService.getStudentById(plan.getStudentId()).get());
        }
        logger.info("List of students of the class with id: {} has been sent to the front-end successfully.",courseId);
        MDC.clear();
        return list;
    }

}
