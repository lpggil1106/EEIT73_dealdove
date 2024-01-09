package com.dealdove.service;

import com.dealdove.interfaces.CouponRepository;
import com.dealdove.model.Coupon;

public class couponService {
    private CouponRepository couponRepository;

    public couponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public Coupon findByCouponCode(String couponCode) {

        return (Coupon) couponRepository.findByCouponCode(couponCode);
    }
}
