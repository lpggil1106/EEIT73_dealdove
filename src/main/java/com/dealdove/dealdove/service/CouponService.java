package com.dealdove.dealdove.service;

import com.dealdove.dealdove.model.dao.CouponRepository;
import com.dealdove.dealdove.model.enitity.Coupon;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
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
    @Autowired
    public CouponService(CouponRepository couponRepository) {

        this.couponRepository = couponRepository;
    }

    public List<Coupon> findAllCouponBases() {
        return couponRepository.findAllCoupons();
    }

//    public Coupon getCouponByID(Integer couponID){
//        return couponRepository.getCouponByID(couponID);
//    }

    public void saveCoupon(LinkedHashMap<String, String> user){
        FirebaseToken decodedToken = getFirebaseToken(user.get("idToken"));
        String ownerID = decodedToken.getUid();
        Coupon coupon = new Coupon();
        coupon.setOwnerID(ownerID);
    }
}
