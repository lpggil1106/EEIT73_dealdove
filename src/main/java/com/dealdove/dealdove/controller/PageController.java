package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class PageController {

    UserService userService;

    public PageController(UserService userService) {
        this.userService = userService;
    }

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
    @ResponseBody
    public String cvs_callback(@RequestBody String callbackData){
        System.out.println("收到cvs_callback");
        System.out.println(callbackData);
        HashMap<String,String> shopMap = userService.decoded(callbackData);
        String htmlContent = "<html><body><a href='/Member' style='text-decoration=none'>返回會員中心</a></body></html>";
        return "寄送店名:"+shopMap.get("storename")+"<br>店號:"+shopMap.get("storeid")+"<br>地址:"+shopMap.get("storeaddress")+"<br>"+htmlContent;
    }


}
