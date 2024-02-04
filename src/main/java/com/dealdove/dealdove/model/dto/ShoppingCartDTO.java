package com.dealdove.dealdove.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingCartDTO {
    private Integer shoppingCartItemID;
    private String coverImageURL;
    private String productName;
    private String models;
    private Integer price;
    private Integer quantity;
    private String sellerID;
    private String sellerName;

    public ShoppingCartDTO(Integer shoppingCartItemID, String coverImageURL, String productName, String models, Integer price, Integer quantity) {
        this.shoppingCartItemID = shoppingCartItemID;
        this.coverImageURL = coverImageURL;
        this.productName = productName;
        this.models = models;
        this.price = price;
        this.quantity = quantity;
    }

    public ShoppingCartDTO(Integer shoppingCartItemID, String coverImageURL, String productName, String models, Integer price, Integer quantity, String sellerID, String sellerName) {
        this.shoppingCartItemID = shoppingCartItemID;
        this.coverImageURL = coverImageURL;
        this.productName = productName;
        this.models = models;
        this.price = price;
        this.quantity = quantity;
        this.sellerID = sellerID;
        this.sellerName = sellerName;
    }
}
