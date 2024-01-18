package com.dealdove.dealdove.model;

import jakarta.persistence.*;

@Entity
@Table(name = "productImageTable", schema = "dealdove")
public class ProductImageTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productImageID", nullable = false)
    private Integer id;

    @Column(name = "productID", nullable = false)
    private Integer productID;

    @Column(name = "image")
    private byte[] image;

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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}