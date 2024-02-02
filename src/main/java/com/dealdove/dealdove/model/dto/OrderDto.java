package com.dealdove.dealdove.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
    private String buyerComment;
    private String shippingAddress; // 新增的收貨地址欄位

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

    // ...其他 getter 和 setter 方法
}
