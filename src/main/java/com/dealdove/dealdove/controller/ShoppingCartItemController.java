package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.dto.ShoppingCartDTO;
import com.dealdove.dealdove.service.ShoppingCartItemService;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/getCartItems")
    public @ResponseBody Map<String,List<ShoppingCartDTO>> getCartItems(@RequestBody LinkedHashMap<String, String> idToken){
        System.out.println("getCartItems");
        System.out.println("userID: " + idToken);
        return shoppingCartItemService.getCartItems(idToken);
    }

    @GetMapping("/deleteCartItem/{shoppingCartItemID}")
    public String deleteCartItem(@PathVariable int shoppingCartItemID){
        shoppingCartItemService.deleteByShoppingCartItemID(shoppingCartItemID);
        return "Product deleted from cart successfully";
    }

    @GetMapping("/updateCartItem/{shoppingCartItemID}/{quantity}")
    public String updateCartItem(@PathVariable int shoppingCartItemID, @PathVariable int quantity){
        System.out.println("updateCartItem");
        shoppingCartItemService.updateQuantityByShoppingCartItemID(shoppingCartItemID, quantity);
        return "Product updated in cart successfully";
    }

}

