package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.enitity.ShoppingCartItem;
import com.dealdove.dealdove.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/09_checkoutPage")
public class CheckoutController {

    private final CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }


    @GetMapping("/{productID}/images")
    public ResponseEntity<List<String>> getProductImages(@PathVariable Integer productID) {
        List<String> images = checkoutService.getProductImages(productID);
        if (images.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(images);
        }
    }
    @GetMapping("/product/details/{productID}")
    public ResponseEntity<String> getProductDetails(@PathVariable int productID) {
        String productName = checkoutService.getProductName(productID);
        if (productName != null && !productName.isEmpty()) {
            return ResponseEntity.ok(productName);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/shoppingCart/{userID}/cartItems")
    public ResponseEntity<List<ShoppingCartItem>> getShoppingCartItems(@PathVariable String userID) {
        List<ShoppingCartItem> cartItems = checkoutService.getCartItemsByUserId(userID);
        if(cartItems != null && !cartItems.isEmpty()) {
            return ResponseEntity.ok(cartItems);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @GetMapping("/shoppingCart/{userID}/modelInfo")
//    public ResponseEntity<?> getShoppingCartModelAndQuantity(@PathVariable String userID) {
//        // 找商品規格
//        String models = checkoutService.getModelsForUser(userID);
//        // 找下單數量
//        Integer quantity = checkoutService.getQuantityForUser(userID);
//
//        // 检查規格和下單量是否存在
//        if(models != null && quantity != null) {
//            // 如果两者都存在，将它们一起返回
//            Map<String, Object> response = new HashMap<>();
//            response.put("models", models);
//            response.put("quantity", quantity);
//            return ResponseEntity.ok().body(response);
//        } else {
//            // 如果任一不存在，返回404 Not Found
//            return ResponseEntity.notFound().build();
//        }
//    }
}