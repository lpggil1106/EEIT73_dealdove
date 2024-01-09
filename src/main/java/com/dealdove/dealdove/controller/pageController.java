package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.User;
import com.dealdove.dealdove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
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
    public List<User> test2(){
        System.out.println("test2 started");
        //回傳userService查詢到的資料
        System.out.println(userService.findAllUsers());
        return userService.findAllUsers();
    }

}
