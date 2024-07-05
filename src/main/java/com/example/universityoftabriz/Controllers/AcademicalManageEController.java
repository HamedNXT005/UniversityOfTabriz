package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.Employee;
import com.example.universityoftabriz.Services.EmployeeService;
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
public class AcademicalManageEController {
    @Autowired
    private EmployeeService employeeService;
    private static final Logger logger = LoggerFactory.getLogger(AcademicalManageEController.class);
    @RequestMapping("/EmployeePanel/AcademicalManageE")
    public String AcademicalManageE(Model model){
        Optional<Employee> employee = employeeService.getEmployeeByID(LoginController.uid);
        Employee employee1 = employee.get();
        String ImageUrl = employee1.getPhoto();
        model.addAttribute("ImageURL" , ImageUrl);
        return "AcademicalManageE";
    }

    @GetMapping("/EmployeePanel/AcademicalManageE/getInfo")
    @ResponseBody
    public Optional<Employee> getEmployeeInfo(){
        Optional<Employee> employee = employeeService.getEmployeeByID(LoginController.uid);
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Employee's info with id: {} has been sent to the front-end",LoginController.uid);
        MDC.clear();
        return Optional.of(employee.get());
    }

    @GetMapping("/EmployeePanel/AcademicalManageE/getEmployee")
    @ResponseBody
    public List<Employee> getEmployeeAcademy(){
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Info of the Employees of the Academical Affairs department has been sent to the front-end");
        MDC.clear();
        return employeeService.getEmployeesByDepartmentAndRole("AcademicalAffairs" , "Employee");
    }

    @PostMapping("/EmployeePanel/AcademicalManageE/manageEmployee")
    @ResponseBody
    public void manageEmployee(@RequestParam long id){
        Optional<Employee> employee = employeeService.getEmployeeByID(id);
        Employee employee1 = employee.get();

        if (employee1.isAccess()){
            employee1.setAccess(false);
            MDC.put("uid", String.valueOf(LoginController.uid));
            logger.info("Employee's access with id: {} has been denied.",id);
            MDC.clear();
        }else {
            employee1.setAccess(true);
            MDC.put("uid", String.valueOf(LoginController.uid));
            logger.info("Employee's access with id: {} has been granted",id);
            MDC.clear();
        }
        employeeService.updateEmployee(employee1);
    }
}
