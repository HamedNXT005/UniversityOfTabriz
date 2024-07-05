package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.Employee;
import com.example.universityoftabriz.Objects.HistorySalary;
import com.example.universityoftabriz.Objects.Teacher;
import com.example.universityoftabriz.Objects.TeachersSalary;
import com.example.universityoftabriz.Services.EmployeeService;
import com.example.universityoftabriz.Services.HistorySalaryService;
import com.example.universityoftabriz.Services.TeacherService;
import com.example.universityoftabriz.Services.TeachersSalaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
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
    private static final Logger logger = LoggerFactory.getLogger(SalaryPaymentController.class);

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
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Employee's info with id: {} has been sent to the front-end",LoginController.uid);
        MDC.clear();
        return employeeService.getEmployeeByID(LoginController.uid);
    }

    @GetMapping("/Employee/Finance/SalaryPayment/ShowSalary")
    @ResponseBody
    public List<TeachersSalary> getTeachersSalary() {
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Teachers salaries have been sent to the front-end.");
        MDC.clear();
        return teachersSalaryService.getAll();
    }

    @GetMapping("/Employee/Finance/SalaryPayment/getTeacher")
    @ResponseBody
    public Teacher getTeacher(@RequestParam Long id) {
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Teacher's info with id: {} has been sent to the front-end",id);
        MDC.clear();
        return teacherService.getTeacherByID(id).get();
    }

    @GetMapping("/Employee/Finance/SalaryPayment/getTeacherSalary")
    @ResponseBody
    public TeachersSalary getTeacherSalary(@RequestParam Long id) {
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Teacher's salary with id: {} has been sent to the front-end",id);
        MDC.clear();
        return teachersSalaryService.getTeachersSalaryByUid(id);
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
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Teacher's salary with id: {} has been updated.",teachersSalary.getId());
        MDC.clear();
        teachersSalaryService.updateTeacherSalary(teachersSalary);
    }
}
