package com.dealdove.dealdove.service;

import com.dealdove.dealdove.model.enitity.ShoppingCartItem;
import com.dealdove.dealdove.model.dao.ShoppingCartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class ShoppingCartItemService {
    private final ShoppingCartItemRepository shoppingCartItemRepository;

    @Autowired
    public ShoppingCartItemService(ShoppingCartItemRepository shoppingCartItemRepository){
        this.shoppingCartItemRepository = shoppingCartItemRepository;
    }

    public void addToCart(LinkedHashMap<String, String> shoppingCart) {
        // 呼叫 Repository 將資料存入資料庫
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setProductID(Integer.valueOf(shoppingCart.get("productID")));
        shoppingCartItem.setModels(shoppingCart.get("models"));
        shoppingCartItem.setQuantity(Integer.valueOf(shoppingCart.get("quantity")));
        shoppingCartItem.setUserID(shoppingCart.get("userID"));
        shoppingCartItemRepository.save(shoppingCartItem);
    }
}




