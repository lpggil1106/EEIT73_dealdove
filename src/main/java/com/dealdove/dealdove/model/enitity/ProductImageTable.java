package com.dealdove.dealdove.model.enitity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "productImageTable", schema = "dealdove")
public class ProductImageTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productImageID", nullable = false)
    private Integer id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "productID", nullable = false)
    private Product product;

    @Column(name = "image")
    private String image;

    public Integer getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}