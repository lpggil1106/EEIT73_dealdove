package com.dealdove.dealdove.model.enitity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Data
@Entity
@Table(name = "orderItem")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderItemID", nullable = false)
    private Integer orderItemID;

    @Column(name = "orderID", nullable = false)
    private Integer orderID;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "productID", nullable = false)
    private Product product;

    @Column(name = "model", nullable = true, length = 100)
    private String model;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "createTime", nullable = false)
    private Instant createTime;

    @Column(name = "lastEdit", nullable = false)
    private Instant lastEdit;

}