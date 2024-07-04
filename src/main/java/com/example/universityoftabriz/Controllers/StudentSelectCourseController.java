package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.*;
import com.example.universityoftabriz.Objects.DefinedCourses;
import com.example.universityoftabriz.Objects.HistoryOfPassedCourses;
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

import java.util.*;

@Controller
public class StudentSelectCourseController {
    private static final Logger logger = LoggerFactory.getLogger(StudentSelectCourseController.class);
    @Autowired
    private StudentService studentService;
    @Autowired
    private CoursesService coursesService;
    @Autowired
    private ChemistryDefinedCoursesService chemistryDefinedCoursesService;
    @Autowired
    private ChemistryHistoryOfPassedCoursesService chemistryHistoryOfPassedCoursesService;
    @Autowired
    private ChemistryStudentsPlanService chemistryStudentsPlanService;
    @Autowired
    private ComputerDefinedCoursesService computerDefinedCoursesService;
    @Autowired
    private ComputerHistoryOfPassedCoursesService computerHistoryOfPassedCoursesService;
    @Autowired
    private ComputerStudentsPlanService computerStudentsPlanService;
    @Autowired
    private ElectricDefinedCoursesService electricDefinedCoursesService;
    @Autowired
    private ElectricHistoryOfPassedCoursesService electricHistoryOfPassedCoursesService;
    @Autowired
    private ElectricStudentsPlanService electricStudentsPlanService;
    @Autowired
    private MechanicDefinedCoursesService mechanicDefinedCoursesService;
    @Autowired
    private MechanicHistoryOfPassedCoursesService mechanicHistoryOfPassedCoursesService;
    @Autowired
    private MechanicStudentsPlanService mechanicStudentsPlanService;
    @Autowired
    private CivilDefinedCoursesService civilDefinedCoursesService;
    @Autowired
    private CivilHistoryOfPassedCoursesService civilHistoryOfPassedCoursesService;
    @Autowired
    private CivilStudentsPlanService civilStudentsPlanService;

    @RequestMapping("/StudentPanel/StudentSelectCourse")
    public String StudentCoursesList(Model model) {
        Optional<Student> student = studentService.getStudentById(LoginController.uid);
        Student student1 = student.get();

        String ImageUrl = student1.getPhoto();
        model.addAttribute("ImageURL" , ImageUrl);

        return "StudentSelectCourse";
    }

    @GetMapping("/StudentPanel/StudentSelectCourse/getInfo")
    @ResponseBody
    public Optional<Student> getEmployeeInfo(){
        Optional<Student> student = studentService.getStudentById(LoginController.uid);
        return Optional.of(student.get());
    }

    @GetMapping("/StudentPanel/StudentSelectCourse/getAvailableCoursesForComputer")
    @ResponseBody
    public List<ComputerDefinedCourses> getAvailableCoursesForComputer(@RequestParam Student student){
        List<ComputerDefinedCourses> availableCourses = computerDefinedCoursesService.getAvailableCourses();
        List<ComputerHistoryOfPassedCourses> passedCourses = computerHistoryOfPassedCoursesService.getHistoryOfPCByStudentId(student.getId());
        deletePassedCourses(availableCourses,passedCourses);
        trimAvailableCourses(availableCourses,passedCourses,coursesService);
        MDC.put("uid",String.valueOf(LoginController.uid));
        logger.info("Available courses for selection sent to the front-end");
        MDC.clear();
        return availableCourses;
    }

    @GetMapping("/StudentPanel/StudentSelectionCourse/submitForComputer")
    @ResponseBody
    public void submitForComputer(@RequestParam Student student,@RequestParam List<ComputerDefinedCourses> courses){
        MDC.put("uid",String.valueOf(LoginController.uid));
        for (ComputerDefinedCourses course:courses){
            ComputerStudentsPlan studentsPlan = new ComputerStudentsPlan();
            studentsPlan.setStudentId(student.getId());
            studentsPlan.setCourseId(course.getCourseId());
            studentsPlan.setGrade(0f);
            computerStudentsPlanService.updateComputerStudentsPlan(studentsPlan);
            course.setCapacity(course.getCapacity()-1);
            computerDefinedCoursesService.updateComputerDefinedCourses(course);
            logger.info("Course with id: {} was added successfully to the student's plan.",course.getCourseId());
        }
        logger.info("All courses were added successfully to the student's plan.");
        MDC.clear();
    }

    @GetMapping("/StudentPanel/StudentSelectCourse/getAvailableCoursesForChemistry")
    @ResponseBody
    public List<ChemistryDefinedCourses> getAvailableCoursesForChemistry(@RequestParam Student student){
        List<ChemistryDefinedCourses> availableCourses = chemistryDefinedCoursesService.getAvailableCourses();
        List<ChemistryHistoryOfPassedCourses> passedCourses = chemistryHistoryOfPassedCoursesService.getHistoryOfPCByStudentId(student.getId());
        deletePassedCourses(availableCourses,passedCourses);
        trimAvailableCourses(availableCourses,passedCourses,coursesService);
        MDC.put("uid",String.valueOf(LoginController.uid));
        logger.info("Available courses for selection sent to the front-end");
        MDC.clear();
        return availableCourses;
    }

    @GetMapping("/StudentPanel/StudentSelectionCourse/submitForChemistry")
    @ResponseBody
    public void submitForChemistry(@RequestParam Student student,@RequestParam List<ChemistryDefinedCourses> courses){
        MDC.put("uid",String.valueOf(LoginController.uid));
        for (ChemistryDefinedCourses course:courses){
            ChemistryStudentsPlan studentsPlan = new ChemistryStudentsPlan();
            studentsPlan.setStudentId(student.getId());
            studentsPlan.setCourseId(course.getCourseId());
            studentsPlan.setGrade(0f);
            chemistryStudentsPlanService.updateChemistryStudentsPlan(studentsPlan);
            course.setCapacity(course.getCapacity()-1);
            chemistryDefinedCoursesService.updateChemistryDefinedCourses(course);
            logger.info("Course with id: {} was added successfully to the student's plan.",course.getCourseId());
        }
        logger.info("All courses were added successfully to the student's plan.");
        MDC.clear();
    }

    @GetMapping("/StudentPanel/StudentSelectCourse/getAvailableCoursesForCivil")
    @ResponseBody
    public List<CivilDefinedCourses> getAvailableCoursesForCivil(@RequestParam Student student){
        List<CivilDefinedCourses> availableCourses = civilDefinedCoursesService.getAvailableCourses();
        List<CivilHistoryOfPassedCourses> passedCourses = civilHistoryOfPassedCoursesService.getHistoryOfPCByStudentId(student.getId());
        deletePassedCourses(availableCourses,passedCourses);
        trimAvailableCourses(availableCourses,passedCourses,coursesService);
        MDC.put("uid",String.valueOf(LoginController.uid));
        logger.info("Available courses for selection sent to the front-end");
        MDC.clear();
        return availableCourses;
    }

    @GetMapping("/StudentPanel/StudentSelectionCourse/submitForCivil")
    @ResponseBody
    public void submitForCivil(@RequestParam Student student,@RequestParam List<CivilDefinedCourses> courses){
        MDC.put("uid",String.valueOf(LoginController.uid));
        for (CivilDefinedCourses course:courses){
            CivilStudentsPlan studentsPlan = new CivilStudentsPlan();
            studentsPlan.setStudentId(student.getId());
            studentsPlan.setCourseId(course.getCourseId());
            studentsPlan.setGrade(0f);
            civilStudentsPlanService.updateCivilStudentsPlan(studentsPlan);
            course.setCapacity(course.getCapacity()-1);
            civilDefinedCoursesService.updateCivilDefinedCourses(course);
            logger.info("Course with id: {} was added successfully to the student's plan.",course.getCourseId());
        }
        logger.info("All courses were added successfully to the student's plan.");
        MDC.clear();
    }

    @GetMapping("/StudentPanel/StudentSelectCourse/getAvailableCoursesForElectric")
    @ResponseBody
    public List<ElectricDefinedCourses> getAvailableCoursesForElectric(@RequestParam Student student){
        List<ElectricDefinedCourses> availableCourses = electricDefinedCoursesService.getAvailableCourses();
        List<ElectricHistoryOfPassedCourses> passedCourses = electricHistoryOfPassedCoursesService.getHistoryOfPCByStudentId(student.getId());
        deletePassedCourses(availableCourses,passedCourses);
        trimAvailableCourses(availableCourses,passedCourses,coursesService);
        MDC.put("uid",String.valueOf(LoginController.uid));
        logger.info("Available courses for selection sent to the front-end");
        MDC.clear();
        return availableCourses;
    }

    @GetMapping("/StudentPanel/StudentSelectionCourse/submitForElectric")
    @ResponseBody
    public void submitForElectric(@RequestParam Student student,@RequestParam List<ElectricDefinedCourses> courses){
        MDC.put("uid",String.valueOf(LoginController.uid));
        for (ElectricDefinedCourses course:courses){
            ElectricStudentsPlan studentsPlan = new ElectricStudentsPlan();
            studentsPlan.setStudentId(student.getId());
            studentsPlan.setCourseId(course.getCourseId());
            studentsPlan.setGrade(0f);
            electricStudentsPlanService.updateElectricStudentsPlan(studentsPlan);
            course.setCapacity(course.getCapacity()-1);
            electricDefinedCoursesService.updateElectricDefinedCourses(course);
            logger.info("Course with id: {} was added successfully to the student's plan.",course.getCourseId());
        }
        logger.info("All courses were added successfully to the student's plan.");
        MDC.clear();
    }

    @GetMapping("/StudentPanel/StudentSelectCourse/getAvailableCoursesForMechanic")
    @ResponseBody
    public List<MechanicDefinedCourses> getAvailableCoursesForMechanic(@RequestParam Student student){
        List<MechanicDefinedCourses> availableCourses = mechanicDefinedCoursesService.getAvailableCourses();
        List<MechanicHistoryOfPassedCourses> passedCourses = mechanicHistoryOfPassedCoursesService.getHistoryOfPCByStudentId(student.getId());
        deletePassedCourses(availableCourses,passedCourses);
        trimAvailableCourses(availableCourses,passedCourses,coursesService);
        MDC.put("uid",String.valueOf(LoginController.uid));
        logger.info("Available courses for selection sent to the front-end");
        MDC.clear();
        return availableCourses;
    }

    @GetMapping("/StudentPanel/StudentSelectionCourse/submitForMechanic")
    @ResponseBody
    public void submitForMechanic(@RequestParam Student student,@RequestParam List<MechanicDefinedCourses> courses){
        MDC.put("uid",String.valueOf(LoginController.uid));
        for (MechanicDefinedCourses course:courses){
            MechanicStudentsPlan studentsPlan = new MechanicStudentsPlan();
            studentsPlan.setStudentId(student.getId());
            studentsPlan.setCourseId(course.getCourseId());
            studentsPlan.setGrade(0f);
            mechanicStudentsPlanService.updateMechanicStudentsPlan(studentsPlan);
            course.setCapacity(course.getCapacity()-1);
            mechanicDefinedCoursesService.updateMechanicDefinedCourses(course);
            logger.info("Course with id: {} was added successfully to the student's plan.",course.getCourseId());
        }
        logger.info("All courses were added successfully to the student's plan.");
        MDC.clear();
    }

    private static <T extends DefinedCourses, U extends HistoryOfPassedCourses> void deletePassedCourses(List<T> available, List<U> passed) {
        Iterator<T> availableIterator = available.iterator();
        while (availableIterator.hasNext()) {
            T course = availableIterator.next();
            for (U passedCourse : passed) {
                if (Objects.equals(course.getCourseId(), passedCourse.getCourseId())&&passedCourse.isStatus()) {
                    availableIterator.remove();
                    break;
                }
            }
        }
    }

    private static <T extends DefinedCourses, U extends HistoryOfPassedCourses> void trimAvailableCourses(List<T> available, List<U> passed,CoursesService coursesService){
        Iterator<T> availableIterator = available.iterator();
        while (availableIterator.hasNext()){
            T course = availableIterator.next();
            boolean requirement = false;
            Courses aCourse = coursesService.getById(course.getCourseId()).get();
            for (U passedCourse : passed){
                if (Objects.equals(passedCourse.getCourseId(), aCourse.getRequirement())&&passedCourse.isStatus()) {
                    requirement = true;
                    break;
                }
            }
            if (!requirement)
                availableIterator.remove();
        }
    }

}
