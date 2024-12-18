package com.brianuceda.springboot_testing.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
    @Value("${app.production}")
    private Boolean production;
    
    @GetMapping("/test")
    public String test() {
        return "Welcome from Spring Boot Application. Production: " + production;
    }
}
