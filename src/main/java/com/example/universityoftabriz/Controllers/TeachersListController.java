package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.Employee;
import com.example.universityoftabriz.Objects.Student;
import com.example.universityoftabriz.Objects.Teacher;
import com.example.universityoftabriz.Services.EmployeeService;
import com.example.universityoftabriz.Services.StudentService;
import com.example.universityoftabriz.Services.TeacherService;
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
public class TeachersListController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private TeacherService teacherService;

    private static final Logger logger = LoggerFactory.getLogger(TeachersListController.class);
    @RequestMapping("/EmployeePanel/TeachersList")
    public String TeachersPanel(Model model){
        Optional<Employee> employee = employeeService.getEmployeeByID(LoginController.uid);
        Employee employee1 = employee.get();
        String ImageUrl = employee1.getPhoto();
        model.addAttribute("ImageURL" , ImageUrl);
        return "TeachersList";
    }

    @GetMapping("/EmployeePanel/TeachersList/getInfo")
    @ResponseBody
    public Optional<Employee> getEmployeeInfo(){
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Employee's info with id: {} has been sent to the front-end",LoginController.uid);
        MDC.clear();
        return employeeService.getEmployeeByID(LoginController.uid);
    }

    @GetMapping("/EmployeePanel/TeachersList/getTeachers")
    @ResponseBody
    public List<Teacher> getTeachers(){
        return teacherService.getAll();
    }

    @PostMapping("/EmployeePanel/TeachersList/manageTeacher")
    @ResponseBody
    public void manageTeacher(@RequestParam long id){
        Optional<Teacher> teacher = teacherService.getTeacherByID(id);
        Teacher teacher1 = teacher.get();

        if (teacher1.isAccess()){
            teacher1.setAccess(false);
        }else {
            teacher1.setAccess(true);
        }

        teacherService.updateTeacher(teacher1);
    }
}
