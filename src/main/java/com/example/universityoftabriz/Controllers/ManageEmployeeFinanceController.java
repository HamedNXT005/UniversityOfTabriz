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
public class ManageEmployeeFinanceController {
    @Autowired
    private EmployeeService employeeService;
    private static final Logger logger = LoggerFactory.getLogger(ManageEmployeeFinanceController.class);
    @RequestMapping("/Employee/Finance/ManageEmployee")
    public String ManageEmployees(Model model){
        Optional<Employee> employee = employeeService.getEmployeeByID(LoginController.uid);
        Employee employee1 = employee.get();
        String ImageUrl = employee1.getPhoto();
        model.addAttribute("ImageURL" , ImageUrl);
        return "ManageEmployeeFinance";
    }

    @GetMapping("/Employee/Finance/ManageEmployee/getInfo")
    @ResponseBody
    public Optional<Employee> getEmployeeInfo(){
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Employee's info with id: {} has been sent to the front-end",LoginController.uid);
        MDC.clear();
        return employeeService.getEmployeeByID(LoginController.uid);
    }


    @GetMapping("/Employee/Finance/ManageEmployee/getEmployee")
    @ResponseBody
    public List<Employee> getFinanceEmployees(){
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Info of the Employees of the Finance department has been sent to the front-end");
        MDC.clear();
        return employeeService.getEmployeesByDepartmentAndRole("Finance" , "Employee");
    }

    @PostMapping("/Employee/Finance/ManageEmployee/manageEmployee")
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
