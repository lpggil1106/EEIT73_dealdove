package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.enitity.Coupon;
import com.dealdove.dealdove.service.CouponService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class couponController {
    @Autowired
    private CouponService couponService;


    @PostMapping("/getCoupon")
    public void test(@RequestBody LinkedHashMap<String, String> user){
        couponService.saveCoupon(user);
    }
}
