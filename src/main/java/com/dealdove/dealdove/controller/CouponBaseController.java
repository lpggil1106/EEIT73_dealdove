package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.dao.CouponBaseRepository;
import com.dealdove.dealdove.model.enitity.Coupon;
import com.dealdove.dealdove.model.enitity.CouponBase;
import com.dealdove.dealdove.service.CouponBaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CouponBaseController {
    CouponBaseService couponBaseService;

    public CouponBaseController(CouponBaseService couponBaseService) {
        this.couponBaseService = couponBaseService;
    }

    @GetMapping("/15_coupon_page")
    public List<CouponBase> test(){
        System.out.println(couponBaseService.findAllCouponBases());
        return couponBaseService.findAllCouponBases();
    }

}
