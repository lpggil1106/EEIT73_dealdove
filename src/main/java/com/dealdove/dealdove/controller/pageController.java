package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.User;
import com.dealdove.dealdove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class pageController {

    @GetMapping("/test")
    public String test(){
        return "test";
    }
    @GetMapping("/Dealdove" )
    public String homePage(){
        return "01_home_page";
    }

    @GetMapping("/Login")
    public String loginPage(){
        return "02-1_login";
    }
    @GetMapping("/Register")
    public String registerPage(){
        return "02-2_register";
    }
    @GetMapping("/Member")
    public String memberPage(){
        return "03_member";
    }
    @GetMapping("/product")
    public String productPage(){
        return "06_product_home_page";
    }
    @GetMapping("/test2")
    public String test2(){
        return "test";
    }

    @GetMapping("/seller")
    public String userPage(){
        return "10_seller_home_page";
    }


    @GetMapping("ecpayReturn")
    public String ecpayReturn(){
        return "ecpayReturn";
    }


}
