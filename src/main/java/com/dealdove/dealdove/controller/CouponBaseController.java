package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.dao.CouponBaseRepository;
import com.dealdove.dealdove.model.enitity.Coupon;
import com.dealdove.dealdove.model.enitity.CouponBase;
import com.dealdove.dealdove.service.CouponBaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CouponBaseController {
    private CouponBaseService couponBaseService;

    public CouponBaseController(CouponBaseService couponBaseService) {
        this.couponBaseService = couponBaseService;
    }

    @RequestMapping("/Coupon/showCoupon")
    @ResponseBody
    public List<CouponBase> test(){
        return couponBaseService.findAllCouponBases();
    }

}
