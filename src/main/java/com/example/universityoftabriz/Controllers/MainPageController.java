package com.example.universityoftabriz.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {
    @RequestMapping("/MainPage")
    public String MainPage(){
        return "MainPage";
    }
}
