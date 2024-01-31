package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.service.ShoppingCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shoppingCart")
public class ShoppingCartItemController {
    @Autowired
    private  ShoppingCartItemService shoppingCartItemService;

    @PostMapping("/addToCart")
    public String addToCart(@RequestBody ShoppingCartItemService.CartRequest cartRequest){
        System.out.println("success");
//        shoppingCartItemService.addToCart(cartRequest);
        return "Product added to cart successfully";
    }
}

