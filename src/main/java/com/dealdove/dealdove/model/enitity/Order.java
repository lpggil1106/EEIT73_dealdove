package com.dealdove.dealdove.model.enitity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderID", nullable = false)
    private Integer orderID;

    @Column(name = "sellerID", nullable = true)
    private String sellerID;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @OneToMany
    @JoinColumn(name = "orderID")
    private List<OrderItem> orderItems;

    @Column(name = "buyerID", nullable = true)
    private String buyerID;

    @Column(name = "paymentID", nullable = true)
    private Integer paymentID;

    @Column(name = "couponID")
    private Integer couponID;

    @Column(name = "buyerComment", length = 300)
    private String buyerComment;

    @Column(name = "sellerComment", length = 300)
    private String sellerComment;

    @Column(name = "orderStatus", nullable = true)
    private Integer orderStatus;

    @Column(name = "orderDate", nullable = true)
    private ZonedDateTime orderDate;

    @Column(name = "totalPrice", nullable = true)
    private Integer totalPrice;

    @Column(name = "shippingAddress", nullable = true, length = 100)
    private String shippingAddress;
}