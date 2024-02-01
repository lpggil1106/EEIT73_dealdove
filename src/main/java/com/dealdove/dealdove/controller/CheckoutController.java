package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/09_checkoutPage")
public class CheckoutController {

    private final CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }



    @GetMapping("/shoppingCart/{userID}/modelInfo")
    public ResponseEntity<?> getShoppingCartModelAndQuantity(@PathVariable String userID) {
        // 找商品規格
        String models = checkoutService.getModelsForUser(userID);
        // 找下單數量
        Integer quantity = checkoutService.getQuantityForUser(userID);

        // 检查規格和下單量是否存在
        if(models != null && quantity != null) {
            // 如果两者都存在，将它们一起返回
            Map<String, Object> response = new HashMap<>();
            response.put("models", models);
            response.put("quantity", quantity);
            return ResponseEntity.ok().body(response);
        } else {
            // 如果任一不存在，返回404 Not Found
            return ResponseEntity.notFound().build();
        }
    }

//    @GetMapping("/shoppingCart/{userID}/productName")
//    public ResponseEntity<?> getProductName(@PathVariable String userID) {
//        // 获取模型信息
//        String models = checkoutService.getProductNameForUser(userID);
//
//
//        // 检查模型信息和商品数量是否存在
//        if(models != null ) {
//            // 如果两者都存在，将它们一起返回
//            Map<String, Object> response = new HashMap<>();
//            response.put("models", models);
//
//            return ResponseEntity.ok().body(response);
//        } else {
//            // 如果任一不存在，返回404 Not Found
//            return ResponseEntity.notFound().build();
//        }
//    }

}