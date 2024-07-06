package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.Employee;
import com.example.universityoftabriz.Objects.Student;
import com.example.universityoftabriz.Services.EmployeeService;
import com.example.universityoftabriz.Services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Controller
public class FacultyStudentsListController {
    @Autowired
    private EmployeeService employeeService;
    private static final Logger logger = LoggerFactory.getLogger(FacultyStudentsListController.class);
    @Autowired
    private StudentService studentService;

    @RequestMapping("/EmployeePanel/FacultyStudentsList")
    public String FacultyStudentsList(Model model){
        Optional<Employee> employee = employeeService.getEmployeeByID(LoginController.uid);
        Employee employee1 = employee.get();
        String ImageUrl = employee1.getPhoto();
        model.addAttribute("ImageURL" , ImageUrl);
        return "FacultyStudentsList";
    }

    @GetMapping("/EmployeePanel/FacultyStudentsList/getInfo")
    @ResponseBody
    public Optional<Employee> getEmployeeInfo(){
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Employee's info with id: {} has been sent to the front-end",LoginController.uid);
        MDC.clear();
        return employeeService.getEmployeeByID(LoginController.uid);
    }

    @GetMapping("/EmployeePanel/FacultyStudentsList/ComputerList")
    @ResponseBody
    public List<Student> GetCStudents() {
        return studentService.getStudentsByFaculty("computer");
    }
    @GetMapping("/EmployeePanel/FacultyStudentsList/CivilList")
    @ResponseBody
    public List<Student> GetCivilList() {
        return studentService.getStudentsByFaculty("civil");
    }
    @GetMapping("/EmployeePanel/FacultyStudentsList/ChemistryList")
    @ResponseBody
    public List<Student> GetChemistryList() {
        return studentService.getStudentsByFaculty("chemistry");
    }
    @GetMapping("/EmployeePanel/FacultyStudentsList/ElectricList")
    @ResponseBody
    public List<Student> GetEList() {
        return studentService.getStudentsByFaculty("electric");
    }
    @GetMapping("/EmployeePanel/FacultyStudentsList/MechanicList")
    @ResponseBody
    public List<Student> GetMechanicList() {
        return studentService.getStudentsByFaculty("mechanic");
    }

    @PostMapping("/EmployeePanel/FacultyStudentsList/manageStudent")
    @ResponseBody
    public void manageStudent(@RequestParam long id){
        Optional<Student> student = studentService.getStudentById(id);
        Student student1 = student.get();

        if (student1.isAccess()){
            student1.setAccess(false);
        }else {
            student1.setAccess(true);
        }

        studentService.updateStudent(student1);
    }
}
