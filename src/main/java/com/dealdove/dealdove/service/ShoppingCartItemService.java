package com.dealdove.dealdove.service;

import com.dealdove.dealdove.model.dto.ProductHomeDTO;
import com.dealdove.dealdove.model.dto.ShoppingCartDTO;
import com.dealdove.dealdove.model.enitity.ShoppingCartItem;
import com.dealdove.dealdove.model.dao.ShoppingCartItemRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

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
        shoppingCartItem.setPrice(Integer.valueOf(shoppingCart.get("price")));
        shoppingCartItemRepository.save(shoppingCartItem);
    }

    public Map<String, List<ShoppingCartDTO>> getCartItems(LinkedHashMap<String, String> user) {
        FirebaseToken decodedToken = getFirebaseToken(user.get("idToken"));
        String userID = decodedToken.getUid();
        List<Object[]> temp = shoppingCartItemRepository.findCheckoutDetailByUserID(userID);
        Map<String, List<ShoppingCartDTO>> groupedBySeller = new HashMap<>();

        for (Object[] row : temp) {
            Integer shoppingCartItemID = (Integer) row[0];
            String coverImageURL = (String) row[1];
            String productName = (String) row[2];
            String models = (String) row[3];
            Integer price =  ((BigDecimal)row[4]).intValue();
            Integer quantity = ((BigDecimal)row[5]).intValue();
            String sellerID = (String) row[6];
            String sellerName = (String) row[7];

            ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO(shoppingCartItemID, coverImageURL, productName, models, price, quantity, sellerID, sellerName);

            // 檢查是否已經存在對應的 sellerID
            if (groupedBySeller.containsKey(sellerID)) {
                // 若已存在，將 ShoppingCartDTO 加入該 sellerID 的 List
                groupedBySeller.get(sellerID).add(shoppingCartDTO);
            } else {
                // 若不存在，創建新的 List 並加入
                List<ShoppingCartDTO> newList = new ArrayList<>();
                newList.add(shoppingCartDTO);
                groupedBySeller.put(sellerID, newList);
            }
        }

        return groupedBySeller;
    }

    public void deleteByShoppingCartItemID(Integer ShoppingCartItemID) {
        shoppingCartItemRepository.deleteByShoppingCartItemID(ShoppingCartItemID);
    }

    public void updateQuantityByShoppingCartItemID(Integer ShoppingCartItemID, Integer quantity) {
        shoppingCartItemRepository.updateQuantityByShoppingCartItemID(ShoppingCartItemID, quantity);
    }
}




