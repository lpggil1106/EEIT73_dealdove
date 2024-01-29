package com.dealdove.dealdove.model.dto;

import com.dealdove.dealdove.model.Product;

public class ProductHomeDTO {
    private Product product;
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

    public ProductHomeDTO(Product product, String PriceRange, String frontImage, double averageRating) {
        this.product = product;
        this.frontImage = frontImage;
        this.PriceRange = PriceRange;
        this.averageRating = averageRating;
    }

    public void setProduct(Product product) {
        this.product = product;
    }





    public Product getProduct() {
        return product;
    }


}
