package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.Coupon;
import com.dealdove.dealdove.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class couponController {
    @Autowired
    private CouponService couponService;

    @RequestMapping("/15_coupon_page")
    @ResponseBody
    public List<Coupon> test(){
        return couponService.findAllCoupons();
        //System.out.println(couponService.findAllCoupons()+"123123");
        // System.out.println("123123");
        //return null;
    }
}