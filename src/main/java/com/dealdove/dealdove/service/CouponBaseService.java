package com.dealdove.dealdove.service;

import com.dealdove.dealdove.model.dao.CouponBaseRepository;
import com.dealdove.dealdove.model.enitity.CouponBase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponBaseService {
    private CouponBaseRepository couponBaseRepository;

    public CouponBaseService(CouponBaseRepository couponBaseRepository) {
        this.couponBaseRepository = couponBaseRepository;
    }

    public List<CouponBase> findAllCouponBases(){
        return couponBaseRepository.findAllCouponBases();
    }
}
