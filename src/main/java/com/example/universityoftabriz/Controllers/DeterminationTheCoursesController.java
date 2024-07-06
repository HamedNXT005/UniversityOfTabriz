package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.*;
import com.example.universityoftabriz.Services.*;
import com.example.universityoftabriz.Objects.Employee;
import com.example.universityoftabriz.Objects.Resources;
import com.example.universityoftabriz.Services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class DeterminationTheCoursesController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ComputerPreCoursesPlanService computerPreCoursesPlanService;
    @Autowired
    private CivilPreCoursesPlanService civilPreCoursesPlanService;
    @Autowired
    private ChemistryPreCoursesPlanService chemistryPreCoursesPlanService;
    @Autowired
    private ElectricPreCoursesPlanService electricPreCoursesPlanService;
    @Autowired
    private MechanicPreCoursesPlanService mechanicPreCoursesPlanService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CoursesService coursesService;

    private static final Logger logger = LoggerFactory.getLogger(DeterminationTheCoursesController.class);
    @RequestMapping("/EmployeePanel/DeterminationTheCourses")
    public String DeterminationTheCourses(Model model){
        Optional<Employee> employee = employeeService.getEmployeeByID(LoginController.uid);
        Employee employee1 = employee.get();
        String ImageUrl = employee1.getPhoto();
        model.addAttribute("ImageURL" , ImageUrl);
        return "DeterminationTheCourses";
    }

    @GetMapping("/EmployeePanel/DeterminationTheCourses/getInfo")
    @ResponseBody
    public Optional<Employee> getEmployeeInfo(){
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Employee's info with id: {} has been sent to the front-end",LoginController.uid);
        MDC.clear();
        return employeeService.getEmployeeByID(LoginController.uid);
    }

    @GetMapping("/EmployeePanel/DeterminationTheCourses/getComputerCourses")
    @ResponseBody
    public List<ComputerPreCoursesPlan> getCCoursesPlan(){
        return computerPreCoursesPlanService.getAll();
    }
    @GetMapping("/EmployeePanel/DeterminationTheCourses/getCivilCourses")
    @ResponseBody
    public List<CivilPreCoursesPlan> getCiCoursesPlan(){
        return civilPreCoursesPlanService.getAll();
    }
    @GetMapping("/EmployeePanel/DeterminationTheCourses/getCHCourses")
    @ResponseBody
    public List<ChemistryPreCoursesPlan> getCHCoursesPlan(){
        return chemistryPreCoursesPlanService.getAll();
    }
    @GetMapping("/EmployeePanel/DeterminationTheCourses/getECourses")
    @ResponseBody
    public List<ElectricPreCoursesPlan> getECoursesPlan(){
        return electricPreCoursesPlanService.getAll();
    }
    @GetMapping("/EmployeePanel/DeterminationTheCourses/getMCourses")
    @ResponseBody
    public List<MechanicPreCoursesPlan> getMCoursesPlan(){
        return mechanicPreCoursesPlanService.getAll();
    }

    @GetMapping("/EmployeePanel/DeterminationTheCourses/getTInfo")
    @ResponseBody
    public Teacher getTeacherInfo(@RequestParam long id){
        Optional<Teacher> teacher = teacherService.getTeacherByID(id);
        return teacher.get();
    }

    @GetMapping("/EmployeePanel/DeterminationTheCourses/getCourseInfo")
    @ResponseBody
    public Courses getCourseName(@RequestParam long id){
        Optional<Courses> course = coursesService.getById(id);
        return course.get();
    }

    @PostMapping("/EmployeePanel/DeterminationTheCourses/UpdateStatus")
    @ResponseBody
    public void UpdateStatus(@RequestParam long Cid , @RequestParam long id){
        Optional<Courses> courses = coursesService.getById(Cid);
        Courses courses1 = courses.get();
        System.out.println(courses1);
        if (Objects.equals(courses1.getFaculty(), "computer")){
            Optional<ComputerPreCoursesPlan> computerPreCoursesPlan1 = computerPreCoursesPlanService.getPreCourse(id);
            ComputerPreCoursesPlan computerPreCoursesPlan = computerPreCoursesPlan1.get();
            if (computerPreCoursesPlan.isStatus()){
                computerPreCoursesPlan.setStatus(false);
            }else {
                computerPreCoursesPlan.setStatus(true);
            }
            computerPreCoursesPlanService.updateComputerPreCoursesPlan(computerPreCoursesPlan);
        } else if (Objects.equals(courses1.getFaculty(), "civil")) {
            Optional<CivilPreCoursesPlan> civilPreCoursesPlan1 = civilPreCoursesPlanService.getCourse(id);
            CivilPreCoursesPlan civilPreCoursesPlan = civilPreCoursesPlan1.get();
            if (civilPreCoursesPlan.isStatus()){
                civilPreCoursesPlan.setStatus(false);
            }else {
                civilPreCoursesPlan.setStatus(true);
            }
            civilPreCoursesPlanService.updateCivilPreCoursesPlan(civilPreCoursesPlan);
        }else if (Objects.equals(courses1.getFaculty(), "chemistry")) {
            Optional<ChemistryPreCoursesPlan> chemistryPreCoursesPlan1 = chemistryPreCoursesPlanService.getCourse(id);
            ChemistryPreCoursesPlan chemistryPreCoursesPlan = chemistryPreCoursesPlan1.get();
            if (chemistryPreCoursesPlan.isStatus()){
                chemistryPreCoursesPlan.setStatus(false);
            }else {
                chemistryPreCoursesPlan.setStatus(true);
            }
            chemistryPreCoursesPlanService.updateChemistryPreCoursesPlan(chemistryPreCoursesPlan);
        }else if (Objects.equals(courses1.getFaculty(), "electric")) {
            Optional<ElectricPreCoursesPlan> electricPreCoursesPlan1 = electricPreCoursesPlanService.getCourse(id);
            ElectricPreCoursesPlan electricPreCoursesPlan = electricPreCoursesPlan1.get();
            if (electricPreCoursesPlan.isStatus()){
                electricPreCoursesPlan.setStatus(false);
            }else {
                electricPreCoursesPlan.setStatus(true);
            }
            electricPreCoursesPlanService.updateElectricPreCoursesPlan(electricPreCoursesPlan);
        }else if (Objects.equals(courses1.getFaculty(), "mechanic")) {
            Optional<MechanicPreCoursesPlan> mechanicPreCoursesPlan1 = mechanicPreCoursesPlanService.getCourse(id);
            MechanicPreCoursesPlan mechanicPreCoursesPlan = mechanicPreCoursesPlan1.get();
            if (mechanicPreCoursesPlan.isStatus()){
                mechanicPreCoursesPlan.setStatus(false);
            }else {
                mechanicPreCoursesPlan.setStatus(true);
            }
            mechanicPreCoursesPlanService.updateMechanicPreCoursesPlan(mechanicPreCoursesPlan);
        }

    }


}
