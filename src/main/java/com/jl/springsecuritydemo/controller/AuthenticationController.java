package com.jl.springsecuritydemo.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @GetMapping("/default/hello")
    public String getHello() {
        return "hello";
    }

    @GetMapping("/custom/hi")
    public String sayHi() {
        return "Hi";
    }


    @GetMapping("/auth/with-role")
    public String checkRole() {
        SecurityContext context = SecurityContextHolder.getContext();
        return String.format("current user has role %s",
                context.getAuthentication().getAuthorities());
    }
}
