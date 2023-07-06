package com.CourseSecurity.Security.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    @RolesAllowed("ROLE_USER")
    public String getHome(){
        return "Olá!";
    }

}
