package com.dealdove.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;

public interface CouponRepository<coupon, Integer extends Serializable> extends JpaRepository<coupon, Integer> {
    List<coupon> findByCouponCode(@Param("coupon") String couponCode);

}
