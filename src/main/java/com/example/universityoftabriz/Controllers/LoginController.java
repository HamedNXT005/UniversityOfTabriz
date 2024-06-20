package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.Student;
import com.example.universityoftabriz.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.apache.logging.log4j.ThreadContext;
import java.util.List;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    public static long uid = 100;

    @Autowired
    private StudentService studentService;
    @RequestMapping("/")
    public String Login(){
        MDC.put("uid", String.valueOf(uid));
        logger.info("Application Started.");
        MDC.clear();
        uid = 101;
        return "Login";
    }

    @GetMapping("/api/getStudents")
    @ResponseBody
    public List<Student> getAllStudents(){
        MDC.put("uid", String.valueOf(uid));
        logger.info("Got Students.");
        MDC.clear();
        return studentService.getStudent();
    }
}
