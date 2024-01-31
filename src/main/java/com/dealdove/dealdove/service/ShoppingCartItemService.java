package com.dealdove.dealdove.service;

import com.dealdove.dealdove.model.enitity.ShoppingCartItem;
import com.dealdove.dealdove.model.dao.ShoppingCartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartItemService {
    @Autowired
    private ShoppingCartItemRepository shoppingCartItemRepository;

    public static class CartRequest {
        private Integer productID;
        private String models;
        private Integer quantity;
        private String userID;

        // 此處需要提供相應的 getters 和 setters

        public Integer getProductID() {
            return productID;
        }

        public void setProductID(Integer productID) {
            this.productID = productID;
        }

        public String getModels() {
            return models;
        }

        public void setModels(String models) {
            this.models = models;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }
    }

    public void addToCart(CartRequest cartRequest) {
        if (cartRequest.getProductID() == null) {
            throw new IllegalArgumentException("ProductID cannot be null");
        }
        // 呼叫 Repository 將資料存入資料庫
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setProductID(cartRequest.getProductID());
        shoppingCartItem.setModels(cartRequest.getModels());
        shoppingCartItem.setQuantity(cartRequest.getQuantity());
        shoppingCartItem.setUserID(cartRequest.getUserID());
        System.out.println(shoppingCartItem+"ffff");
        shoppingCartItemRepository.save(shoppingCartItem);
    }
}
