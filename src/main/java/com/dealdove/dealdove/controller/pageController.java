package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.User;
import com.dealdove.dealdove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class pageController {
    @Autowired
    private UserService userService;
    private  int id;
    private String name;

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
    public String test1(@RequestParam String name,Integer id){

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
        System.out.println("test2 started");
        //回傳userService查詢到的資料
        return userService.findAllUsers();
    }

    @GetMapping("/hello")
    public String sayHello() {
        System.out.println("Hello from your controller!");
        return "Hello from your controller!";
    }
}

