package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.Employee;
import com.example.universityoftabriz.Objects.Teacher;
import com.example.universityoftabriz.Services.EmployeeService;
import com.example.universityoftabriz.Services.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class TeacherSalaryPaymentController {
    @Autowired
    private TeacherService teacherService;
    private static final Logger logger = LoggerFactory.getLogger(TeacherSalaryPaymentController.class);
    @RequestMapping("/TeacherPanel/TeacherSalaryPayment")
    public String StudentsList(Model model){
        Optional<Teacher> teacher = teacherService.getTeacherByID(LoginController.uid);
        Teacher teacher1 = teacher.get();

        String ImageUrl = teacher1.getPhoto();
        model.addAttribute("ImageURL" , ImageUrl);
        return "TeacherSalaryPayment";
    }

    @GetMapping("/TeacherPanel/TeacherSalaryPayment/getInfo")
    @ResponseBody
    public Optional<Teacher> getTeacherInfo(){
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Teacher's info with id: {} has been sent to the front-end",LoginController.uid);
        MDC.clear();
        return teacherService.getTeacherByID(LoginController.uid);
    }
}
