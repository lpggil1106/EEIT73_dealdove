//package com.dealdove.dealdove.model.dto;
//
//import com.dealdove.dealdove.model.enitity.Coupon;
//import com.dealdove.dealdove.model.enitity.CouponBase;
//
//import java.time.ZonedDateTime;
//
//public class CouponWithBaseInfoDto {
//    private Long couponId;
//    private String ownerID;
//    private Integer isUsed;
//    private ZonedDateTime creationDate;
//    private Integer couponBaseID;
//    private String couponBaseName; // 假設 CouponBase 有一個名稱屬性
//    // 其他 CouponBase 的相關屬性
//
//    // 構造函數、getter 和 setter 略
//
//    public CouponWithBaseInfoDto(Coupon coupon, CouponBase couponBase) {
//        this.couponId = coupon.getId();
//        this.ownerID = coupon.getOwnerID();
//        this.isUsed = coupon.getIsUsed();
//        this.creationDate = coupon.getCreationDate();
//        this.couponBaseID = couponBase.getId();
//        this.couponBaseName = couponBase.getName();
//        // 初始化其他 CouponBase 的相關屬性
//    }
//
//    // getter 和 setter 方法
//}
