package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {
    

    @GetMapping("/demo")
    public String demo() {
        return "Demo!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }
}
