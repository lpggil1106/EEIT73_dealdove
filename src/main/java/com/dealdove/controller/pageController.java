package com.dealdove.controller;

import com.dealdove.interfaces.UserRepository;
import com.dealdove.model.User;
import com.dealdove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    private String test1(@RequestParam String name,Integer id){

        this.id = id;
        this.name=name;
        //在那邊印出回傳直 炒沙小
        //哪個SB用spring io
        return id+""+name;

    }

    //get request from fronted
    @RequestMapping("/test2")
    //接收成功時執行的method
    public List<User> test2(){
        //回傳userService查詢到的資料
        return userService.findAllUsers();
    }
}

