package com.jl.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("default")
public class DefaultAuthController {

    @GetMapping("hello")
    public String getHello(){
        return "hello";
    }
}
