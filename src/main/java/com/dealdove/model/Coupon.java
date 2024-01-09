package com.dealdove.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int couponID;

    @Column(name = "couponCode" , nullable = false , unique = true)
    private String couponCode;

    @Column(name = "ownerID" , nullable = false)
    private int ownerID;

    @Column(name = "discount" , nullable = false)
    private double discount;

    @Column(name = "isUsed" , nullable = false)
    private boolean isUsed;

    @Column(name = "minimumAmount" , nullable = true)
    private int minimumAmount;

    @Column(name = "applicableCategoriesID" , nullable = true)
    private int applicableCategoriesID;

    @Column(name = "expirationDate" , nullable = true)
    private LocalDate expirationDate;

    @Column(name = "creationDate" , nullable = false)
    private LocalDate creationDate;

    public Coupon(){};// default constructor
    public Coupon(String couponCode, int ownerID, double discount, boolean isUsed, int minimumAmount, int applicableCategoriesID, LocalDate expirationDate, LocalDate creationDate) {
        this.couponCode = couponCode;
        this.ownerID = ownerID;
        this.discount = discount;
        this.isUsed = isUsed;
        this.minimumAmount = minimumAmount;
        this.applicableCategoriesID = applicableCategoriesID;
        this.expirationDate = expirationDate;
        this.creationDate = creationDate;
    }
    public int getCouponID() {
        return couponID;
    }

    public void setCouponID(int couponID) {
        this.couponID = couponID;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public int getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(int minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    public int getApplicableCategoriesID() {
        return applicableCategoriesID;
    }

    public void setApplicableCategoriesID(int applicableCategoriesID) {
        this.applicableCategoriesID = applicableCategoriesID;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }


}
