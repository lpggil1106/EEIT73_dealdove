package com.dealdove.dealdove.model.enitity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "couponBase", schema = "dealdove")
public class CouponBase {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer couponBaseID;

    @Column(name = "couponName", nullable = false, length = 30)
    private String couponName;

    @Column(name = "couponCode", nullable = false, length = 20)
    private String couponCode;

    @Column(name = "couponDescription", nullable = false, length = 200)
    private String couponDescription;

    @Column(name = "discount")
    private double discount;

    @Column(name = "discountMethod")
    private int discountMethod;

    @Column(name = "applicableCategoriesID")
    private int applicableCategoriesID;

    @Column(name = "minimumAmount")
    private int minimumAmount;

    @OneToMany(mappedBy = "couponBase")
    private List<Coupon> coupon;

}
