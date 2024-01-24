package com.dealdove.dealdove.model.dto;

import com.dealdove.dealdove.model.Product;

public class ProductHomeDTO {
    private Product product;
    private Integer MaxPrice;
    private Integer MinPrice;

    public ProductHomeDTO(Product product, Integer MaxPrice, Integer MinPrice) {
        this.product = product;
        this.MaxPrice = MaxPrice;
        this.MinPrice = MinPrice;
    }

    public Product getProduct() {
        return product;
    }


}
