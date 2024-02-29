package com.dealdove.dealdove.model.enitity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Data
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewID", nullable = false)
    private Integer reviewID;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "productID", nullable = false)
    private Product product;

    @Column(name = "userID", nullable = false)
    private String userID;

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

}