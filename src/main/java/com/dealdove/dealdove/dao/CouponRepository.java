package com.dealdove.dealdove.dao;

import com.dealdove.dealdove.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
    @Query(value = "SELECT * FROM coupon", nativeQuery = true)
    List<Coupon> findAllCoupons();
}
