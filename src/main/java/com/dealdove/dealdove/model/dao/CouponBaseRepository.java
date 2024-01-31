package com.dealdove.dealdove.model.dao;

import com.dealdove.dealdove.model.enitity.Coupon;
import com.dealdove.dealdove.model.enitity.CouponBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponBaseRepository extends JpaRepository<CouponBase,Integer> {

    @Query(value = "SELECT * FROM couponBase",nativeQuery = true)
    public List<CouponBase> findAllCouponBases();
}
