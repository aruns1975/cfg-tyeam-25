package com.cfg.team25.socialtown.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
@RequestMapping("/api/test")
public class GreetController {
     @Autowired
     DataSource dataSource;
    @GetMapping("/")
    public String greet(){
        return "Hello, World";
    }
}
