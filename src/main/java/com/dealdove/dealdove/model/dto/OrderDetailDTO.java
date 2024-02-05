package com.dealdove.dealdove.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


public class OrderDetailDTO {
    private String userName;
    private String buyerID;
    private Integer orderID;
    private String productName;
    private int quantity;
    private String model;
    private Integer totalPrice;
    private Integer orderStatus;
    private String shippingAddress;
    private String coverImageURL;

    public String getCoverImageURL() {
        return coverImageURL;
    }

    public void setCoverImageURL(String coverImageURL) {
        this.coverImageURL = coverImageURL;
    }
// Constructors, getters, and setters

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBuyerID() {
        return buyerID;
    }

    public void setBuyerID(String buyerID) {
        this.buyerID = buyerID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public OrderDetailDTO(String userName, String buyerID, Integer orderID, String productName, int quantity, String model,
                          Integer totalPrice, Integer orderStatus, String shippingAddress, String coverImageURL) {
        this.userName = userName;
        this.buyerID = buyerID;
        this.orderID = orderID;
        this.productName = productName;
        this.quantity = quantity;
        this.model = model;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        this.shippingAddress = shippingAddress;
        this.coverImageURL = coverImageURL;
    }

    public OrderDetailDTO() {

    }
    // Getters and setters
}
