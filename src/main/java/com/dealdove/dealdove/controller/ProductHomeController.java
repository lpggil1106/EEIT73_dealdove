package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.dto.ProductHomeDTO;
import com.dealdove.dealdove.model.enitity.Product;
import com.dealdove.dealdove.service.ModelInfoService;
import com.dealdove.dealdove.service.ProductService;
import com.dealdove.dealdove.service.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductHomeController {
    private ProductService productService;
    private ModelInfoService modelInfoService;

    public ProductHomeController(ProductService productService, ModelInfoService modelInfoService) {
        this.productService = productService;
        this.modelInfoService = modelInfoService;
    }
    @GetMapping("/getProduct")
    public List<ProductHomeDTO> showAllProduct() {

        System.out.println(productService.getProductDetails());
        List<Object[]> resultList = productService.getProductDetails();

        List<ProductHomeDTO> productDTOList = new ArrayList<>();

        for (Object[] row : resultList) {
            Integer productID = (Integer) row[0];
            String productName = (String) row[1];
            Integer minPrice = (Integer) row[2];
            Integer maxPrice = (Integer) row[3];
            Double avgRating = (row[4] != null) ? (Double) row[4]:0.0;
            String coverImageURL = (row[5] != null) ? (String) row[5] : "https://static.vecteezy.com/system/resources/previews/005/337/799/large_2x/icon-image-not-found-free-vector.jpg";
            Integer soldQuantity = (row[6] != null) ? (Integer) row[6]: 0;

            ProductHomeDTO productDTO = new ProductHomeDTO(productID, productName, minPrice, maxPrice, avgRating, coverImageURL, soldQuantity);
            productDTOList.add(productDTO);
        }
        return productDTOList;

    }

    private ProductHomeDTO mapToProductHomeDTO(Integer productID, String productName, Integer minPrice,Integer maxPrice,  Double avgRating, String coverImageURL,Integer soldQuantity) {
        return new ProductHomeDTO(productID, productName, minPrice, maxPrice, avgRating, coverImageURL, soldQuantity);
    }
}
