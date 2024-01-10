package com.dealdove.dealdove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pageController {

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
