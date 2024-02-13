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
    private int quantity;
    private String productName;
    private String model;
    private String image;
    // 默认构造函数
    public OrderDto() {}

    @Override
    public String toString() {
        return "OrderDto{" +
                "buyerComment='" + buyerComment + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", totalPrice=" + totalPrice +
                ", paymentID=" + paymentID +
                ", orderStatus=" + orderStatus +
                ", buyerID='" + buyerID + '\'' +
                ", quantity=" + quantity +
                ", productName='" + productName + '\'' +
                ", model='" + model + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
