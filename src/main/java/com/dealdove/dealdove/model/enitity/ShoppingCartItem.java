package com.dealdove.dealdove.model.enitity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "shoppingCartItem", schema = "dealdove")
public class ShoppingCartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shoppingCartItemID", nullable = false)
    private Integer shoppingCartItemID;

    @Column(name = "productID", nullable = false)
    private Integer productID;

    @Column(name = "models",length = 10, nullable = false)
    private String models;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "userID", nullable = false)
    private String userID;

    @Column(name = "price", nullable = false)
    private Integer price;
}