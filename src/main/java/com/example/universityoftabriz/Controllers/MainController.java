package com.example.universityoftabriz.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String Main(){
        return "redirect:/Login";
//        return "redirect:/Login";

    }
}
