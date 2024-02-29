package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

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


    @GetMapping("/shoppingCart")
        public String shoppingCart(){
        return "08_shopping_cart";
    }

    @GetMapping("/orderDetail")
    public String sellerOrder(){
        return "07OrderDetail";
    }

    @PostMapping("/ecpayReturn")
    public String ecpayReturn(@RequestBody String callbackData){
        System.out.println(callbackData);
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

    @PostMapping("/cvs_callback2")
    public String cvs_callback2(@RequestBody String callbackData)  {
        System.out.println("收到cvs_callback");
        System.out.println(callbackData);
        HashMap<String,String> shopMap = userService.decoded(callbackData);
        System.out.println("寄送店名:"+shopMap.get("storename")+"<br>店號:"+shopMap.get("storeid")+"<br>地址:"+shopMap.get("storeaddress"));

        String storename = shopMap.get("storename");
        try {
            String encodedStorename = URLEncoder.encode(storename, StandardCharsets.UTF_8.toString());
            String redirectUrl = "/checkout?storename=" + encodedStorename;
            return "redirect:" + redirectUrl;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/testImage")
    public void testImage(@RequestParam("avatar") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                // 在這裡進行你的檔案處理邏輯
                System.out.println("檔案名稱：" + file.getOriginalFilename());
                System.out.println("檔案大小：" + file.getSize());
                System.out.println("檔案類型：" + file.getContentType());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
