package com.dealdove.dealdove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    @GetMapping("/productHome")
    public String productPage(){
        return "06_product_home_page";
    }
    @GetMapping("/test2")
    public String test2(){
        return "test";
    }
    @GetMapping("/seller")
    public String seller(){
        return "10_seller_home_page";
    }
    @GetMapping("/checkout")
    public String checkout(){
        return "09_checkoutPage";
    }
    @GetMapping("/Coupon")
    public String Coupon(){return "15_coupon_page";};

    @GetMapping("ecpayReturn")
    public String ecpayReturn(){
        return "ecpayReturn";
    }

    @PostMapping("/cvs_callback")
    public String cvs_callback(@RequestBody String callbackData){
        System.out.println("收到cvs_callback");
        System.out.println(callbackData);
        return "cvs_callback";
    }


}
