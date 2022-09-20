package com.example.ss_2022_c3_e1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {
    
    @GetMapping("/demo")
    public String demo() {
        return "Demo!";
    }
}
