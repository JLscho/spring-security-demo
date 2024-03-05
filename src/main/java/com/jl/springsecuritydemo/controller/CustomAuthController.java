package com.jl.springsecuritydemo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("custom")
public class CustomAuthController {

    @GetMapping("hi")
    public String sayHi(){
        return "Hi";
    }
}
