package com.dealdove.dealdove.model.enitity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "shoppingCartItem")
public class ShoppingCartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shoopingCartItemID", nullable = false)
    private Integer id;

    @Column(name = "productID", nullable = false)
    private Integer productID;

    @Column(name = "models",length = 10, nullable = false)
    private String models;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "userID", nullable = false)
    private String userID;



}