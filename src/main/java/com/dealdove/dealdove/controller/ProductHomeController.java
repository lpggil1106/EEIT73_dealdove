package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.dto.ProductHomeDTO;
import com.dealdove.dealdove.model.enitity.Product;
import com.dealdove.dealdove.service.ModelInfoService;
import com.dealdove.dealdove.service.ProductService;
import com.dealdove.dealdove.service.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductHomeController {
    private ProductService productService;
    private ModelInfoService modelInfoService;
    private ReviewService reviewService;

    public ProductHomeController(ProductService productService, ModelInfoService modelInfoService, ReviewService reviewService) {
        this.productService = productService;
        this.modelInfoService = modelInfoService;
        this.reviewService = reviewService;
    }
    @GetMapping("/getProduct")
    public List<ProductHomeDTO> showAllProduct() {
        List<ProductHomeDTO> result = productService.getAllProduct().stream()
                .map(product -> {
                    Integer productID = product.getProductID();
                    System.out.println(1);
                    String productName = product.getProductName();
                    System.out.println(2);
                    String priceRange = modelInfoService.getMaxMinPrice(product.getProductID());
                    System.out.println(3);
                    String frontImage = product.getFirstImage();
                    System.out.println(4);
                    double averageRating = product.getReviewsAvgRating();
                    System.out.println(5);
                    return mapToProductHomeDTO(productID, productName, "priceRange", "https://down-tw.img.susercontent.com/file/tw-11134207-7qukz-lg3gbyeti5gq16", 0.0);
//                    return mapToProductHomeDTO(productID, productName, priceRange, frontImage, averageRating);
                })
                .toList();
        return result;
    }

    private ProductHomeDTO mapToProductHomeDTO(Integer productID, String productName, String priceRange, String frontImage, double averageRating) {
        return new ProductHomeDTO(productID, productName, priceRange, frontImage, averageRating);
    }
}
