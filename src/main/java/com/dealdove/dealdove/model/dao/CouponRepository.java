package com.dealdove.dealdove.model.dao;

import com.dealdove.dealdove.model.enitity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
//    @Query(value = "SELECT * FROM coupon WHERE couponBase.couponCode= :couponCode", nativeQuery = true)
//    List<Coupon> findAllCoupons(@Param("couponCode")String couponCode);

    @Query(value = "SELECT * FROM coupon WHERE couponID = :couponID", nativeQuery = true)
    Coupon getCouponByID(Integer couponID);

    @Query(value = "SELECT* FROM coupon WHERE ownerID= :userID",nativeQuery = true)
    public List<Coupon> findCouponByUserID(@Param("userID")String userID);

    Coupon save(Coupon coupon);

    List<Coupon> findAll();

    List<Coupon> findCouponsByOwnerID(String ownerID);
}
