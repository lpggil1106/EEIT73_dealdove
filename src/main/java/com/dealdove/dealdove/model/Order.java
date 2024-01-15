package com.dealdove.dealdove.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.ZonedDateTime;
import java.util.Map;

@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderID", nullable = false)
    private Integer id;

    @Column(name = "sellerID", nullable = false)
    private Integer sellerID;

    @Column(name = "buyerID", nullable = false)
    private Integer buyerID;

    @Column(name = "paymentID", nullable = false)
    private Integer paymentID;

    @Column(name = "couponID")
    private Integer couponID;

    @Column(name = "buyerComment", length = 300)
    private String buyerComment;

    @Column(name = "sellerComment", length = 300)
    private String sellerComment;

    @Column(name = "models", nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> models;

    @Column(name = "orderStatus", nullable = false)
    private Byte orderStatus;

    @Column(name = "orderDate", nullable = false)
    private ZonedDateTime orderDate;

    @Column(name = "totalPrice", nullable = false)
    private Integer totalPrice;

    @Column(name = "shippingAddress", nullable = false, length = 100)
    private String shippingAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSellerID() {
        return sellerID;
    }

    public void setSellerID(Integer sellerID) {
        this.sellerID = sellerID;
    }

    public Integer getBuyerID() {
        return buyerID;
    }

    public void setBuyerID(Integer buyerID) {
        this.buyerID = buyerID;
    }

    public Integer getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Integer paymentID) {
        this.paymentID = paymentID;
    }

    public Integer getCouponID() {
        return couponID;
    }

    public void setCouponID(Integer couponID) {
        this.couponID = couponID;
    }

    public String getBuyerComment() {
        return buyerComment;
    }

    public void setBuyerComment(String buyerComment) {
        this.buyerComment = buyerComment;
    }

    public String getSellerComment() {
        return sellerComment;
    }

    public void setSellerComment(String sellerComment) {
        this.sellerComment = sellerComment;
    }

    public Map<String, Object> getModels() {
        return models;
    }

    public void setModels(Map<String, Object> models) {
        this.models = models;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public ZonedDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(ZonedDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

}