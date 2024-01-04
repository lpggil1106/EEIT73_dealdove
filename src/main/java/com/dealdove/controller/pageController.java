package com.dealdove.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class pageController {
    public String index() {
        return "index";
    }
}
