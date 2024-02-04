package com.dealdove.dealdove.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
    private String buyerComment;
    private String shippingAddress;
    private Integer totalPrice;
    private Integer paymentID;
    private Integer orderStatus;
    private String buyerID;

    // 默认构造函数
    public OrderDto() {}

    // Getter 和 Setter 方法
    public String getBuyerComment() {
        return buyerComment;
    }
    public void setBuyerComment(String buyerComment) {
        this.buyerComment = buyerComment;
    }
    public String getShippingAddress() {
        return shippingAddress;
    }
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    public Integer getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
    public Integer getPaymentID() {
        return paymentID;
    }
    public void setPaymentID(Integer paymentID) {
        this.paymentID = paymentID;
    }
    public Integer getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getBuyerID() {
        return buyerID;
    }
    public void setBuyerID(String buyerID) {
        this.buyerID = buyerID;
    }
}
