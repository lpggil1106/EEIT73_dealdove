package com.dealdove.dealdove.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "review", schema = "dealdove")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReviewID", nullable = false)
    private Integer id;

    @Column(name = "productID", nullable = false)
    private Integer productID;

    @Column(name = "userID", nullable = false)
    private Integer userID;

    @Column(name = "orderID", nullable = false)
    private Integer orderID;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "comment", length = 200)
    private String comment;

    @Column(name = "createTime", nullable = false)
    private Instant createTime;

    @Column(name = "lastEdit", nullable = false)
    private Instant lastEdit;

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

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Instant getLastEdit() {
        return lastEdit;
    }

    public void setLastEdit(Instant lastEdit) {
        this.lastEdit = lastEdit;
    }

}