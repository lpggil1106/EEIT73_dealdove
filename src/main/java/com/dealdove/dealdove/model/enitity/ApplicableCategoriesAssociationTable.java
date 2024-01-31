package com.dealdove.dealdove.model.enitity;

import jakarta.persistence.*;

@Entity
@Table(name = "applicableCategoriesAssociationTable")
public class ApplicableCategoriesAssociationTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicableCategoriesID", nullable = false, unique = true)
    private Integer applicableCategoriesID;

    @Column(name = "couponID", nullable = false)
    private Integer couponID;

    @Column(name = "categoriesID", nullable = false)
    private Integer categoriesID;

    public Integer getApplicableCategoriesID() {
        return applicableCategoriesID;
    }

    public void setApplicableCategoriesID(Integer applicableCategoriesID) {
        this.applicableCategoriesID = applicableCategoriesID;
    }

    public Integer getCouponID() {
        return couponID;
    }

    public void setCouponID(Integer couponID) {
        this.couponID = couponID;
    }


}
