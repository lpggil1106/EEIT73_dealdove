package com.dealdove.dealdove.model.dto;

import com.dealdove.dealdove.model.enitity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductHomeDTO {

    private int productID;
    private String productName;
    private String PriceRange;
    private String frontImage;
    private double averageRating;

    public String getPriceRange() {
        return PriceRange;
    }

    public void setPriceRange(String priceRange) {
        PriceRange = priceRange;
    }

    public String getFrontImage() {
        return frontImage;
    }

    public void setFrontImage(String frontImage) {
        this.frontImage = frontImage;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public ProductHomeDTO(int productID,String productName, String PriceRange, String frontImage, double averageRating) {
        this.productID = productID;
        this.productName = productName;
        this.frontImage = frontImage;
        this.PriceRange = PriceRange;
        this.averageRating = averageRating;
    }



}
