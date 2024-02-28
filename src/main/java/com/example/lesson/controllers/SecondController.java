package com.example.lesson.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/second")
@Controller
public class SecondController {

    @GetMapping("/exit")
    public String exitPage(){
        return "second/exit";
    }
}
