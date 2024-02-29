package com.dealdove.dealdove.model.enitity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "modelInfo", schema = "dealdove")
public class ModelInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "modelInfoID", nullable = false)
    private Integer id;

    @Column(name="productID",nullable = true)
    private Integer productID;

    @Column(name = "firstModelID", nullable = true)
    private Integer firstModelID;

    @Column(name = "secondModelID")
    private Integer secondModelID;

    @Column(name = "price", nullable = true)
    private Integer price;

    @Column(name = "quantity", nullable = true)
    private Integer quantity;
}