package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@RestController
public class CouponController {
    @Autowired
    private CouponService couponService;


    @PostMapping("/getCoupon")
    public int getCoupon(@RequestBody LinkedHashMap<String, String> user) {
        return couponService.saveCoupon(user);
    }
}
