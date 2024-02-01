package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> getShoppingCartModel(@PathVariable String userID) {
        String models = checkoutService.getModelsForUser(userID);
        if(models != null) {
            return ResponseEntity.ok().body(Map.of("models", models));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}