package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.Employee;
import com.example.universityoftabriz.Objects.HistorySalary;
import com.example.universityoftabriz.Objects.Teacher;
import com.example.universityoftabriz.Objects.TeachersSalary;
import com.example.universityoftabriz.Services.EmployeeService;
import com.example.universityoftabriz.Services.HistorySalaryService;
import com.example.universityoftabriz.Services.TeacherService;
import com.example.universityoftabriz.Services.TeachersSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class SalaryPaymentController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private TeachersSalaryService teachersSalaryService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private HistorySalaryService historySalaryService;


    @RequestMapping("/Employee/Finance/SalaryPayment")
    public String SalaryPayment(Model model){
        Optional<Employee> employee = employeeService.getEmployeeByID(LoginController.uid);
        Employee employee1 = employee.get();
        String ImageUrl = employee1.getPhoto();
        model.addAttribute("ImageURL" , ImageUrl);
        return "SalaryPayment";
    }

    @GetMapping("/Employee/Finance/SalaryPayment/getInfo")
    @ResponseBody
    public Optional<Employee> getEmployeeInfo(){
        Optional<Employee> employee = employeeService.getEmployeeByID(LoginController.uid);
        return Optional.of(employee.get());
    }

    @GetMapping("/Employee/Finance/SalaryPayment/ShowSalary")
    @ResponseBody
    public List<TeachersSalary> getTeachersSalary() {
        return teachersSalaryService.getAll();
    }

    @GetMapping("/Employee/Finance/SalaryPayment/getTeacher")
    @ResponseBody
    public Teacher getTeacher(@RequestParam Long id) {
        Optional<Teacher> teacher = teacherService.getTeacherByID(id);
        return teacher.get();
    }

    @GetMapping("/Employee/Finance/SalaryPayment/getTeacherSalary")
    @ResponseBody
    public TeachersSalary getTeacherSalary(@RequestParam Long id) {
        TeachersSalary teachersSalary = teachersSalaryService.getTeachersSalaryByUid(id);
        return teachersSalary;
    }
    @PostMapping("/Employee/Finance/SalaryPayment/UpdateSalary")
    @ResponseBody
    public void UpdateSalary(@RequestBody TeachersSalary teachersSalary){
        Date date = new Date();
        long lastID = 0L;

        HistorySalary historySalary = historySalaryService.getLastRecord();

        if (historySalary == null){
            lastID = 1L;
        }else {
            lastID = historySalary.getId();
        }

        HistorySalary historySalary1 = new HistorySalary();
        historySalary1.setId(lastID + 1);
        historySalary1.setUserId(teachersSalary.getUserId());
        historySalary1.setYearEd(teachersSalary.getYearEd());
        historySalary1.setSemester(teachersSalary.getSemester());
        historySalary1.setSalary(teachersSalary.getSalary());
        historySalary1.setPayment_date(date);
        historySalary1.setHoursTaught(teachersSalary.getHoursTaught());

        historySalaryService.updateHistorySalary(historySalary1);

        teachersSalary.setHoursTaught(0);
        teachersSalary.setSalary(0L);
        teachersSalaryService.updateTeacherSalary(teachersSalary);
    }
}
