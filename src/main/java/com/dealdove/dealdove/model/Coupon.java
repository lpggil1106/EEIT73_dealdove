package com.dealdove.dealdove.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "coupon", schema = "dealdove")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CouponID", nullable = false)
    private Integer id;

    @Column(name = "couponCode", nullable = false, length = 10)
    private String couponCode;

    @Column(name = "ownerID", nullable = false)
    private Integer ownerID;

    @Column(name = "isUsed", nullable = false)
    private Byte isUsed;

    @Column(name = "minimumAamount", nullable = false)
    private Integer minimumAmount;

    @Column(name = "applicableCategoriesID", nullable = false)
    private Integer applicableCategoriesId;

    @Column(name = "expirationDate", nullable = false)
    private Instant expirationDate;

    @Column(name = "creationDate", nullable = false)
    private Instant creationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public Integer getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(Integer ownerID) {
        this.ownerID = ownerID;
    }

    public Byte getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Byte isUsed) {
        this.isUsed = isUsed;
    }

    public Integer getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(Integer minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    public Integer getApplicableCategoriesId() {
        return applicableCategoriesId;
    }

    public void setApplicableCategoriesId(Integer applicableCategoriesId) {
        this.applicableCategoriesId = applicableCategoriesId;
    }

    public Instant getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Instant expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

}