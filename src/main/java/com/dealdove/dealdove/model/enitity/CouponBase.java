package com.dealdove.dealdove.model.enitity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;


@Entity
@Data
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

    @Column(name = "discountMethod",nullable = true)
    private int discountMethod;

    @Column(name = "expirationDate", nullable = false)
    private Instant expirationDate;

    @Column(name = "applicableCategoriesID")
    private int applicableCategoriesID;

    @Column(name = "minimumAmount")
    private int minimumAmount;

    @JsonManagedReference
    @OneToMany(mappedBy = "couponBase")
    private List<Coupon> coupon;

    @Override
    public String toString() {
        return "CouponBase{" +
                "couponBaseID=" + couponBaseID +
                ", couponName='" + couponName + '\'' +
                ", couponCode='" + couponCode + '\'' +
                ", couponDescription='" + couponDescription + '\'' +
                ", discount=" + discount +
                ", discountMethod=" + discountMethod +
                ", expirationDate=" + expirationDate +
                ", applicableCategoriesID=" + applicableCategoriesID +
                ", minimumAmount=" + minimumAmount +
                ", coupon=" + coupon +
                '}';
    }
}
