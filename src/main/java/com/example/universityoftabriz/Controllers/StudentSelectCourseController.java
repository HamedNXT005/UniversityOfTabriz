package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.*;
import com.example.universityoftabriz.Objects.DefinedCourses;
import com.example.universityoftabriz.Objects.HistoryOfPassedCourses;
import com.example.universityoftabriz.Services.*;
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
    @Autowired
    private StudentService studentService;
    @Autowired
    private CoursesService coursesService;
    @Autowired
    private ChemistryDefinedCoursesService chemistryDefinedCoursesService;
    @Autowired
    private ChemistryHistoryOfPassedCoursesService chemistryHistoryOfPassedCoursesService;
    @Autowired
    private ComputerDefinedCoursesService computerDefinedCoursesService;
    @Autowired
    private ComputerHistoryOfPassedCoursesService computerHistoryOfPassedCoursesService;
    @Autowired
    private ElectricDefinedCoursesService electricDefinedCoursesService;
    @Autowired
    private ElectricHistoryOfPassedCoursesService electricHistoryOfPassedCoursesService;
    @Autowired
    private MechanicDefinedCoursesService mechanicDefinedCoursesService;
    @Autowired
    private MechanicHistoryOfPassedCoursesService mechanicHistoryOfPassedCoursesService;
    @Autowired
    private CivilDefinedCoursesService civilDefinedCoursesService;
    @Autowired
    private CivilHistoryOfPassedCoursesService civilHistoryOfPassedCoursesService;

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
        return availableCourses;
    }

    @GetMapping("/StudentPanel/StudentSelectCourse/getAvailableCoursesForChemistry")
    @ResponseBody
    public List<ChemistryDefinedCourses> getAvailableCoursesForChemistry(@RequestParam Student student){
        List<ChemistryDefinedCourses> availableCourses = chemistryDefinedCoursesService.getAvailableCourses();
        List<ChemistryHistoryOfPassedCourses> passedCourses = chemistryHistoryOfPassedCoursesService.getHistoryOfPCByStudentId(student.getId());
        deletePassedCourses(availableCourses,passedCourses);
        trimAvailableCourses(availableCourses,passedCourses,coursesService);
        return availableCourses;
    }

    @GetMapping("/StudentPanel/StudentSelectCourse/getAvailableCoursesForCivil")
    @ResponseBody
    public List<CivilDefinedCourses> getAvailableCoursesForCivil(@RequestParam Student student){
        List<CivilDefinedCourses> availableCourses = civilDefinedCoursesService.getAvailableCourses();
        List<CivilHistoryOfPassedCourses> passedCourses = civilHistoryOfPassedCoursesService.getHistoryOfPCByStudentId(student.getId());
        deletePassedCourses(availableCourses,passedCourses);
        trimAvailableCourses(availableCourses,passedCourses,coursesService);
        return availableCourses;
    }

    @GetMapping("/StudentPanel/StudentSelectCourse/getAvailableCoursesForElectric")
    @ResponseBody
    public List<ElectricDefinedCourses> getAvailableCoursesForElectric(@RequestParam Student student){
        List<ElectricDefinedCourses> availableCourses = electricDefinedCoursesService.getAvailableCourses();
        List<ElectricHistoryOfPassedCourses> passedCourses = electricHistoryOfPassedCoursesService.getHistoryOfPCByStudentId(student.getId());
        deletePassedCourses(availableCourses,passedCourses);
        trimAvailableCourses(availableCourses,passedCourses,coursesService);
        return availableCourses;
    }

    @GetMapping("/StudentPanel/StudentSelectCourse/getAvailableCoursesForMechanic")
    @ResponseBody
    public List<MechanicDefinedCourses> getAvailableCoursesForMechanic(@RequestParam Student student){
        List<MechanicDefinedCourses> availableCourses = mechanicDefinedCoursesService.getAvailableCourses();
        List<MechanicHistoryOfPassedCourses> passedCourses = mechanicHistoryOfPassedCoursesService.getHistoryOfPCByStudentId(student.getId());
        deletePassedCourses(availableCourses,passedCourses);
        trimAvailableCourses(availableCourses,passedCourses,coursesService);
        return availableCourses;
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
