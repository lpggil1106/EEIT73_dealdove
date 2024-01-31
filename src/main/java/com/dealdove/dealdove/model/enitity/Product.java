package com.dealdove.dealdove.model.enitity;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.List;

@Entity

@Table(name = "product", schema = "dealdove")
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

    @Column(name = "userID", length = 200, nullable = true)
    private String userID;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

    @Column(name = "productImageID", nullable = true)
    private Integer productImageID;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public List<ProductImageTable> getProductImageTables() {
        return productImageTables;
    }

    public void setProductImageTable(List<ProductImageTable> productImageTable) {
        this.productImageTables = productImageTable;
    }

//      @OneToMany(mappedBy = "productImageTable", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "product")
    private List<ProductImageTable> productImageTables;


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



    public String getUserID() {
        return userID;
    }

    public void setUserID(String userId) {
        this.userID = userID;
    }


    public Integer getProductImageID() {
        return productImageID;
    }

    public void setProductImageID(Integer productImageID) {
        this.productImageID = productImageID;
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

    public void addProductImage(ProductImageTable productImagetable) {
        productImageTables.add(productImagetable);
        productImagetable.setProduct(this);
    }

    public void removeProductImage(ProductImageTable productImagetable) {
        productImageTables.remove(productImagetable);
        productImagetable.setProduct(null);
    }


//    public String getSubCategory() {
//        String subCategory = null;
//        return subCategory;
//    }
//
//    public void setSubCategory(String subCategory) {
//        this.subCategory = subCategory;
//    }
}