package com.dealdove.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class pageController {


    @GetMapping("/01_home_page")
    public String test(Model model){
        return "01_home_page";
    }

//    test123456
    @GetMapping("/04_product_page")
    public String productPage(Model model){
        return "04_product_page";
    }
}
