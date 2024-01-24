package com.dealdove.dealdove.model;

import jakarta.persistence.*;

@Entity
@Table(name = "productImageTable", schema = "dealdove")
public class ProductImageTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productImageID", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "productID", nullable = false)
    private Product product;

    @Column(name = "image")
    private byte[] image;

    public Integer getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}