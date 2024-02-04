package com.dealdove.dealdove.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
    private String buyerComment;
    private String shippingAddress;
    private Integer totalPrice;

    // 默认构造函数
    public OrderDto() {}
    // Getter 和 Setter 方法
    public String getBuyerComment() {
        return buyerComment;
    }
    public void setBuyerComment(String buyerComment) {
        this.buyerComment = buyerComment;
    }
    // 新增的 Getter 和 Setter 方法
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
}
