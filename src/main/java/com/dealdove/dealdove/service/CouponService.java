package com.dealdove.dealdove.service;

import com.dealdove.dealdove.interfaces.CouponRepository;
import com.dealdove.dealdove.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {
    private CouponRepository couponRepository;
    @Autowired
    public CouponService(CouponRepository couponRepository) {

        this.couponRepository = couponRepository;
    }

    public List<Coupon> findAllCoupons() {

        return couponRepository.findAllCoupons();
    }

}
