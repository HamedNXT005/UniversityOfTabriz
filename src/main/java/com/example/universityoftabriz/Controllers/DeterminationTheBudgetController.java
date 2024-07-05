package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.Employee;
import com.example.universityoftabriz.Objects.Resources;
import com.example.universityoftabriz.Services.EmployeeService;
import com.example.universityoftabriz.Services.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Optional;

@Controller
public class DeterminationTheBudgetController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ResourcesService resourcesService;


    @RequestMapping("/Employee/Finance/DeterminationBudget")
    public String DeterminationBudget(Model model){
        Optional<Employee> employee = employeeService.getEmployeeByID(LoginController.uid);
        Employee employee1 = employee.get();
        String ImageUrl = employee1.getPhoto();
        model.addAttribute("ImageURL" , ImageUrl);
        return "DeterminationTheBudget";
    }

    @GetMapping("/Employee/Finance/DeterminationBudget/getInfo")
    @ResponseBody
    public Optional<Employee> getEmployeeInfo(){
        Optional<Employee> employee = employeeService.getEmployeeByID(LoginController.uid);
        return Optional.of(employee.get());
    }

    @PostMapping("/Employee/Finance/DeterminationBudget/DBudget")
    @ResponseBody
    public void DBudget(@RequestParam int year , @RequestParam int sem , @RequestParam long tBudget){
        System.out.println(year + " " + sem + " " + tBudget);
        String mes = "Not SuccessFul";
        LocalDate localDate = LocalDate.now();
        int data = localDate.getYear();
        Resources resource = resourcesService.getLastRecord();
        long lastId = resource.getId();
        if (resource != null){
            if (data == year){
                if (year == resource.getYearEd() && resource.getSemester() == sem){
                    resource.setTotalBudget(tBudget);
                    resourcesService.updateResource(resource);
                    mes = "Update Successful";
                }else{
                    Resources resource1 = new Resources();
                    resource1.setId(lastId+1);
                    resource1.setYearEd(year);
                    resource1.setSemester(sem);
                    resource1.setTotalBudget(tBudget);
                    resource1.setRateSc(0L);
                    resource1.setRateNormal(0L);
                    resourcesService.updateResource(resource1);
                    mes = "Insert Successful";
                }
            }else {
                mes = "Year isn't correct";
            }
        } else {
            Resources resource1 = new Resources();
            resource1.setId(lastId+1);
            resource1.setYearEd(year);
            resource1.setSemester(sem);
            resource1.setTotalBudget(tBudget);
            resource1.setRateSc(0L);
            resource1.setRateNormal(0L);
            resourcesService.updateResource(resource1);
            mes = "Insert Successful";
        }
    }
}
