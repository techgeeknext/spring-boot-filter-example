package com.techgeeknext.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterExampleController {

    @GetMapping(value = "/welcome")
    public String customGreetings(){
        return "Welcome to TechGeekNext Custom Filter Example!!";
    }
}
