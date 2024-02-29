package com.dealdove.dealdove.model.enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Entity
@Data
@Table(name = "product", schema = "dealdove")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productID", nullable = false)
    private Integer productID;

    @Column(name = "productName", nullable = false, length = 300)
    private String productName;

    @Column(name = "productDescription", nullable = false, length = 500)
    private String productDescription;

    @OneToMany
    @JsonManagedReference
    private List<Review> reviews;

    @Column(name = "productCategoryID", nullable = true)
    private Integer productCategoryID;

    @Column(name = "userID", length = 200, nullable = true)
    private String userID;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private List<OrderItem> orderItems;

    @Column(name = "productImageID", nullable = true)
    private Integer productImageID;

    //      @OneToMany(mappedBy = "productImageTable", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private List<ProductImageTable> productImageTables;

    @Column(name = "isAvailable", nullable = true)
    private Byte isAvailable;

    @Column(name = "createTime", nullable = true)
    private Instant createTime;

    @Column(name = "lastEdit", nullable = true)
    private Instant lastEdit;

    public void addProductImage(ProductImageTable productImagetable) {
        productImageTables.add(productImagetable);
        productImagetable.setProduct(this);
    }

    public void removeProductImage(ProductImageTable productImagetable) {
        productImageTables.remove(productImagetable);
        productImagetable.setProduct(null);
    }

    public String getFirstImage() {
        if (productImageTables != null && !productImageTables.isEmpty()) {
            return productImageTables.get(0).getImage();
        }
        return "https://i0.wp.com/kanzaki-yokkaichi.com/cms/wp-content/uploads/2020/03/non-image.jpg?w=730&ssl=1";

    }

    public Double getReviewsAvgRating() {
        if (reviews.isEmpty()) {
            return 0.0;
        }
        Double sum = 0.0;
        for (Review review : reviews) {
            sum += review.getRating();
        }
        sum = sum / reviews.size();
        return sum;
    }
}