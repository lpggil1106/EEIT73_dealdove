package com.dealdove.dealdove.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductHomeDTO {

    private Integer productID;
    private String productName;
    private Integer minPrice;
    private Integer maxPrice;
    private Double avgRating;
    private String coverImageURL;
    private Integer soldQuantity;

    // Constructors, getters, and setters

    public ProductHomeDTO(Integer productID, String productName, Integer minPrice, Integer maxPrice, Double avgRating, String coverImageURL, Integer soldQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.avgRating = avgRating;
        this.coverImageURL = coverImageURL;
        this.soldQuantity = soldQuantity;
    }

    public ProductHomeDTO() {
        // Default constructor
    }

    @Override
    public String toString() {
        return "ProductHomeDTO{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", avgRating=" + avgRating +
                ", coverImageURL='" + coverImageURL + '\'' +
                ", soldQuantity=" + soldQuantity +
                '}';
    }
}
