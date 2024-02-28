package com.example.lesson;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerHello {

    @GetMapping("/hello")
    public String sayHelloWorld(){
        return "hello_world";
    }
}
