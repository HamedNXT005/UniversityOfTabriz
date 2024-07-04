package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.*;
import com.example.universityoftabriz.Services.*;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.pdf.codec.Base64;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.apache.logging.log4j.ThreadContext;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    public static long uid = 100;
    public static long phaseId = 0;

    @Autowired
    private StudentService studentService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private HistorySalaryService historySalaryService;
    @Autowired
    private SemesterPhaseService semesterPhaseService;

    @RequestMapping("/Login")
    public String Login(){
        MDC.put("uid", String.valueOf(uid));
        logger.info("Application Started.");
        MDC.clear();
        phaseId = semesterPhaseService.getPhase();
        return "Login";
    }

    @GetMapping("/Login/StudentLogin")
    @ResponseBody
    public boolean StudentValidation(@RequestParam String userName ,@RequestParam String password){
        boolean access = false;
        Optional<Student> student = studentService.getStudentByUserName(userName);
        if (student.isPresent()){
            Student student1 = student.get();
            if (Objects.equals(student1.getPassword(), password) && student1.isAccess()){
                access = true;
                uid = student1.getId();
                MDC.put("uid", String.valueOf(uid));
                logger.info("The user is logged in.");
                MDC.clear();
            }
        }
        return access;
    }
    @GetMapping("/Login/TeacherLogin")
    @ResponseBody
    public boolean TeacherValidation(@RequestParam String userName ,@RequestParam String password){
        boolean access = false;
        Optional<Teacher> teacher = teacherService.getTeacherByUserName(userName);
        if (teacher.isPresent()){
            Teacher teacher1 = teacher.get();
            if (Objects.equals(teacher1.getPassword(), password) && teacher1.isAccess()){
                access = true;
                uid = teacher1.getId();
                MDC.put("uid", String.valueOf(uid));
                logger.info("The user is logged in.");
                MDC.clear();
            }
        }
        return access;
    }
    @GetMapping("/Login/EmployeeLogin")
    @ResponseBody
    public boolean EmployeeValidation(@RequestParam String userName ,@RequestParam String password){
        boolean access = false;
        Optional<Employee> employee = employeeService.getEmployeeByUserName(userName);
        System.out.println(employee);
        if (employee.isPresent()){
            Employee employee1 = employee.get();
            if (Objects.equals(employee1.getPassword(), password) && employee1.isAccess()){
                access = true;
                uid = employee1.getId();
                MDC.put("uid", String.valueOf(uid));
                logger.info("The user is logged in.");
                MDC.clear();
            }
        }
        return access;
    }

//    @GetMapping("/Login/exportPdf")
//    @ResponseBody
//    public ResponseEntity<InputStreamResource> exportPDF(@RequestParam Teacher teacher, @RequestParam HistorySalary report){
//        try {
//            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//            historySalaryService.exportSalary(report,teacher,outputStream);
//            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Content-Disposition", "inline; filename=Salary_Report_"+report.getUserId()+"_"+report.getPayment_date()+".pdf");
//            logger.info("Salary report file exported successfully.");
//            return ResponseEntity.ok()
//                    .headers(headers)
//                    .contentType(MediaType.APPLICATION_PDF)
//                    .body(new InputStreamResource(inputStream));
//        } catch (DocumentException | IOException e){
//            logger.error("Couldn't export the salary report file.  Exception:\n"+e);
//            return ResponseEntity.status(500).body(null);
//        }
//    }
}
