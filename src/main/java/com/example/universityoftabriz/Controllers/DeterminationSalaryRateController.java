package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.Employee;
import com.example.universityoftabriz.Objects.Resources;
import com.example.universityoftabriz.Services.EmployeeService;
import com.example.universityoftabriz.Services.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class DeterminationSalaryRateController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ResourcesService resourcesService;

    @RequestMapping("/Employee/Finance/DeterminationSalary")
    public String DeterminationSalary(Model model){
        Optional<Employee> employee = employeeService.getEmployeeByID(LoginController.uid);
        Employee employee1 = employee.get();
        String ImageUrl = employee1.getPhoto();
        model.addAttribute("ImageURL" , ImageUrl);
        return "DeterminationSalaryRate";
    }

    @GetMapping("/EmployeePanel/Finance/DeterminationSalary/getInfo")
    @ResponseBody
    public Optional<Employee> getEmployeeInfo(){
        Optional<Employee> employee = employeeService.getEmployeeByID(LoginController.uid);
        return Optional.of(employee.get());
    }

    @PostMapping("/Employee/Finance/DeterminationBudget/DRate")
    @ResponseBody
    public void DBudget(@RequestParam int year , @RequestParam int sem , @RequestParam long scRate , @RequestParam long nRate){
        String mes = "Not SuccessFul";
        LocalDate localDate = LocalDate.now();
        int data = localDate.getYear();
        Resources resource = resourcesService.getLastRecord();
        System.out.println(resource);
        if (resource != null){
            if (data == year){
                if (year == resource.getYearEd() && resource.getSemester() == sem){
                    resource.setRateSc(scRate);
                    resource.setRateNormal(nRate);
                    resourcesService.updateResource(resource);
                }
            }
        }
    }
}
