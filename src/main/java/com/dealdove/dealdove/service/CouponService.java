package com.dealdove.dealdove.service;

import com.dealdove.dealdove.model.dao.CouponBaseRepository;
import com.dealdove.dealdove.model.dao.CouponRepository;
import com.dealdove.dealdove.model.enitity.Coupon;
import com.dealdove.dealdove.model.enitity.CouponBase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class CouponService {
    public FirebaseToken getFirebaseToken(String userToken) {
        try {
            return FirebaseAuth.getInstance().verifyIdToken(userToken);
        } catch (FirebaseAuthException e) {
            throw new RuntimeException(e);
        }
    }

    private CouponRepository couponRepository;
    private CouponBaseRepository couponBaseRepository;

    @Autowired
    public CouponService(CouponRepository couponRepository,
                         CouponBaseRepository couponBaseRepository) {

        this.couponRepository = couponRepository;
        this.couponBaseRepository = couponBaseRepository;
    }

    public int saveCoupon(LinkedHashMap<String, String> user) {
        FirebaseToken decodedToken = getFirebaseToken(user.get("idToken"));
        String ownerID = decodedToken.getUid();
        int couponBaseID = Integer.parseInt(user.get("couponBaseID"));
        Coupon coupon = new Coupon();
        CouponBase tempBase = couponBaseRepository.findByCouponBaseID(couponBaseID);
        List<Coupon> coupons = couponRepository.findAll();

        //判斷是否重值
        boolean canInsert = true;
        for(Coupon temp :coupons){
            if(temp.getOwnerID().equals(ownerID)&&temp.getCouponBase().getCouponBaseID()==couponBaseID) {
                canInsert=false;
            }
        }

        if(canInsert){
            coupon.setOwnerID(ownerID);
            coupon.setIsUsed((byte) 0);
            coupon.setCouponBase(tempBase);
            couponRepository.save(coupon);
            return 10;
        }
        return 20;
    }
}