package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.Product;
import com.dealdove.dealdove.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/10_seller_home_page")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @RequestMapping("/add_product")
//    public List<Product> addProduct(){
//        Product product = productService.getProductByID(1);
//        System.out.println(productService.getAllProduct()+"000");
//        productService.saveProduct(1, 20, "Product Name", 1, 1, 1, "Product Description", 10, (byte) 1);
//
//        return productService.findProduct();
//    }

    @PostMapping("/add_product")
    public List<Product> addProduct(@RequestParam("productName") String productName,
                                    @RequestParam("productPrice") Integer productPrice,
                                    @RequestParam("productCategoryID") Integer productCategoryID,
                                    @RequestParam("productModelID") Integer productModelID,
                                    @RequestParam("productImageID") Integer productImageID,
                                    @RequestParam("productDescription") String productDescription,
                                    @RequestParam("stockQuantity") Integer stockQuantity,
                                    @RequestParam("isAvailable") Byte isAvailable) {

        productService.saveProduct(1, productPrice, productName, productCategoryID, productModelID,
                productImageID, productDescription, stockQuantity, isAvailable);

        return productService.findProduct();
    }



}
