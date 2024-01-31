package com.dealdove.dealdove.service;

import com.dealdove.dealdove.model.dao.CouponRepository;
import com.dealdove.dealdove.model.enitity.Coupon;
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

    public Coupon getCouponByID(Integer couponID){
        return couponRepository.getCouponByID(couponID);
    }


}
