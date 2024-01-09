package com.dealdove.dealdove.service;

import com.dealdove.dealdove.interfaces.CouponRepository;
import com.dealdove.dealdove.model.Coupon;

public class couponService {
    private CouponRepository couponRepository;

    public couponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public Coupon findByCouponCode(String couponCode) {

        return (Coupon) couponRepository.findByCouponCode(couponCode);
    }
}
