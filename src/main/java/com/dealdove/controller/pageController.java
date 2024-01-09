package com.dealdove.controller;

import com.dealdove.interfaces.UserRepository;
import com.dealdove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class pageController {
    @Autowired
    private UserService userService;


    @GetMapping("/01_home_page")
    public String test(Model model){
        return "01_home_page";
    }

//    test123456
    @GetMapping("/04_product_page")
    public String productPage(Model model){
        return "04_product_page";
    }
    @RequestMapping("/test")
    private String test1(Model model){


        return userService.findAll();
    }
}

