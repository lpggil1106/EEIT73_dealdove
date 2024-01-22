package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.Product;
import com.dealdove.dealdove.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/10_seller_home_page")
public class productController {

    private ProductService productService;

    @Autowired
    public productController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/10_seller_home_page")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
}
