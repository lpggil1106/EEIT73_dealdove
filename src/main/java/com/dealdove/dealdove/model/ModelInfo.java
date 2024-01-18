package com.dealdove.dealdove.model;

import jakarta.persistence.*;

@Entity
@Table(name = "modelInfo", schema = "dealdove")
public class ModelInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "modelInfoID", nullable = false)
    private Integer id;

    @Column(name = "productID", nullable = false)
    private Integer productID;

    @Column(name = "firstModelID", nullable = false)
    private Integer firstModelID;

    @Column(name = "secondModelID")
    private Integer secondModelID;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getFirstModelID() {
        return firstModelID;
    }

    public void setFirstModelID(Integer firstModelID) {
        this.firstModelID = firstModelID;
    }

    public Integer getSecondModelID() {
        return secondModelID;
    }

    public void setSecondModelID(Integer secondModelID) {
        this.secondModelID = secondModelID;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}