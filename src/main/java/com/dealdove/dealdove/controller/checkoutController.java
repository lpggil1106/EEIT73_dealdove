package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.enitity.Product;
import com.dealdove.dealdove.service.CheckoutService;
import com.dealdove.dealdove.service.ModelInfoService;
import com.dealdove.dealdove.service.ProductService;
import com.dealdove.dealdove.service.productModelAssociateTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/09_checkoutPage")
public class checkoutController {


    @Autowired
    private CheckoutService checkoutService;


//    @GetMapping("/checkout")
//    public String showCheckoutPage(Model model) {
//        List<ShoppingCartItem> cartItems = checkoutService.getCartItems();
//        model.addAttribute("cartItems", cartItems);
//        return "checkout"; // checkout.html
//    }


}