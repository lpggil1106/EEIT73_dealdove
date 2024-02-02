package com.dealdove.dealdove.service;

import com.dealdove.dealdove.model.enitity.ShoppingCartItem;
import com.dealdove.dealdove.model.dao.ShoppingCartItemRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
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
    public FirebaseToken getFirebaseToken(String userToken) {
        try {
            return FirebaseAuth.getInstance().verifyIdToken(userToken);
        } catch (FirebaseAuthException e) {
            throw new RuntimeException(e);
        }
    }
    public void addToCart(LinkedHashMap<String, String> shoppingCart) {
        FirebaseToken decodedToken = getFirebaseToken(shoppingCart.get("userID"));
        String userID = decodedToken.getUid();
        // 呼叫 Repository 將資料存入資料庫
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setProductID(Integer.valueOf(shoppingCart.get("productID")));
        shoppingCartItem.setModels(shoppingCart.get("models"));
        shoppingCartItem.setQuantity(Integer.valueOf(shoppingCart.get("quantity")));
        shoppingCartItem.setUserID(userID);
        shoppingCartItemRepository.save(shoppingCartItem);
    }
}




