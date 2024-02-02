package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.service.ShoppingCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@RestController
@RequestMapping("/api/shoppingCart")
public class ShoppingCartItemController {
    private ShoppingCartItemService shoppingCartItemService;

    @Autowired
    public ShoppingCartItemController(ShoppingCartItemService shoppingCartItemService) {
        this.shoppingCartItemService = shoppingCartItemService;
    }
    @PostMapping("/addToCart")
    public String addToCart(@RequestBody LinkedHashMap<String, String> shoppingCart){
        String productID = shoppingCart.get("productID");
        String models = shoppingCart.get("models");
        String quantity = shoppingCart.get("quantity");
        String userID = shoppingCart.get("userID");
        String price = shoppingCart.get("price");
        shoppingCartItemService.addToCart(shoppingCart);
        return "Product added to cart successfully";
    }
}

