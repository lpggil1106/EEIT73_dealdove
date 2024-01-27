package com.dealdove.dealdove.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Table(name = "orderItem")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderItemID", nullable = false)
    private Integer orderItemID;

    @ManyToOne
    @JoinColumn(name = "orderID", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "productID", nullable = false)
    private Product product;

    @Column(name = "model", nullable = true, length = 100)
    private String model;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "createTime", nullable = false)
    private ZonedDateTime createTime;

    @Column(name = "lastEdit", nullable = false)
    private ZonedDateTime lastEdit;

    public String toString() {
        return "OrderItem{" +
                "id=" + orderItemID +
                ", product=" + product +
                ", model='" + model + '\'' +
                ", quantity=" + quantity +
                ", createTime=" + createTime +
                ", lastEdit=" + lastEdit +
                '}';
    }
}