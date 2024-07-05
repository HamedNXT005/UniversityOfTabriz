package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.Employee;
import com.example.universityoftabriz.Services.EmployeeService;
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
        Optional<Employee> employee = employeeService.getEmployeeByID(LoginController.uid);
        return Optional.of(employee.get());
    }


    @GetMapping("/Employee/Finance/ManageEmployee/getEmployee")
    @ResponseBody
    public List<Employee> getFinanceEmployees(){
        return employeeService.getEmployeesByDepartmentAndRole("Finance" , "Employee");
    }

    @PostMapping("/Employee/Finance/ManageEmployee/manageEmployee")
    @ResponseBody
    public void manageEmployee(@RequestParam long id){
        Optional<Employee> employee = employeeService.getEmployeeByID(id);
        Employee employee1 = employee.get();

        if (employee1.isAccess()){
            employee1.setAccess(false);
        }else {
            employee1.setAccess(true);
        }
        employeeService.updateEmployee(employee1);
    }
}
