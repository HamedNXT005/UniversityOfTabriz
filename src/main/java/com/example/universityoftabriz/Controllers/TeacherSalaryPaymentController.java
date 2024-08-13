package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.Employee;
import com.example.universityoftabriz.Objects.HistorySalary;
import com.example.universityoftabriz.Objects.Teacher;
import com.example.universityoftabriz.Services.EmployeeService;
import com.example.universityoftabriz.Services.HistorySalaryService;
import com.example.universityoftabriz.Services.TeacherService;
import com.itextpdf.text.DocumentException;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class TeacherSalaryPaymentController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private HistorySalaryService historySalaryService;
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
    @GetMapping("/TeacherPanel/TeacherSalaryPayment/GetPDF")
    @ResponseBody
    public List<HistorySalary> getHistory(@RequestParam long id){
        return historySalaryService.getHistorySByUserId(id);
    }

    @GetMapping("/TeacherPanel/TeacherSalaryPayment/exportPdf")
    @ResponseBody
    public ResponseEntity<InputStreamResource> exportPDF(@RequestParam long tId, @RequestParam long hId){
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Teacher teacher = teacherService.getTeacherByID(tId).get();
            HistorySalary report = historySalaryService.getHistorySById(hId).get();
            historySalaryService.exportSalary(report,teacher,outputStream);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=Salary_Report_"+report.getUserId()+"_"+report.getPayment_date()+".pdf");
            logger.info("Salary report file exported successfully.");
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(new InputStreamResource(inputStream));
        } catch (DocumentException | IOException e){
            logger.error("Couldn't export the salary report file.  Exception:\n"+e);
            return ResponseEntity.status(500).body(null);
        }
    }
}
