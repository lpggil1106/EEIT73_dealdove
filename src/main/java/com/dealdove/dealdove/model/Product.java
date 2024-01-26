package com.dealdove.dealdove.model;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;

import java.time.Instant;

@Entity
@DynamicInsert
//@DynamicInsert可以只插入有值的欄位
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "productID", nullable = false)
    private Integer productID;

    @Column(name = "productName", nullable = false, length = 300)
    private String productName;

    @Column(name = "productDescription", nullable = false, length = 500)
    private String productDescription;

    @Column(name = "productCategoryID", nullable = true)
    private Integer productCategoryID;

    @Column(name = "productParentID", nullable = true)
    private Integer productParentID;

    @Column(name = "productModelID", nullable = true)
    private Integer productModelID;
    @Column(name = "productPrice", nullable = true)
    private Integer productPrice;

    @Column(name = "userID", nullable = true)
    private Integer userID;




    @Column(name = "productImageID", nullable = true)
    private Integer productImageID;

    @Column(name = "stockQuantity", nullable = true)
    private Integer stockQuantity;

    @Column(name = "soldQuantity", nullable = true)
    private Integer soldQuantity;

    @Column(name = "isAvailable", nullable = true)
    private Byte isAvailable;

    @Column(name = "createTime", nullable = true)
    private Instant createTime;

    @Column(name = "lastEdit", nullable = true)
    private Instant lastEdit;

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getProductCategoryID() {
        return productCategoryID;
    }

    public void setProductCategoryID(Integer productCategoryID) {
        this.productCategoryID = productCategoryID;
    }

    public Integer getProductParentID() {
        return productParentID;
    }

    public void setProductParentID(Integer productParentID) {
        this.productParentID = productParentID;
    }

    public Integer getProductModelID() {
        return productModelID;
    }

    public void setProductModelID(Integer productModelID) {
        this.productModelID = productModelID;
    }
    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userId) {
        this.userID = userID;
    }




    public Integer getProductImageID() {
        return productImageID;
    }

    public void setProductImageID(Integer productImageID) {
        this.productImageID = productImageID;
    }



    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Integer getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(Integer soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public Byte getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Byte isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Instant getLastEdit() {
        return lastEdit;
    }

    public void setLastEdit(Instant lastEdit) {
        this.lastEdit = lastEdit;
    }

}