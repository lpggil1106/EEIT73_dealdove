package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.ModelInfo;
import com.dealdove.dealdove.model.Product;
import com.dealdove.dealdove.service.ProductPageService;
import com.dealdove.dealdove.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class productPageController {
    @Autowired
    private ProductPageService productPageService;

    @GetMapping("/getProduct/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer productId) {
        Product product = productPageService.getProductById(productId);
        //System.out.println(product+"123123");
        // 如果找到商品，返回該商品的資訊和 HTTP 狀態碼 200 OK
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            // 如果商品不存在，返回 HTTP 狀態碼 404 NOT FOUND
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{productId}/specifications")
    public ResponseEntity<Map<String,Map<Integer, String>>> getProductSpecifications(@PathVariable Integer productId) {
        Map<String, Map<Integer, String>> specifications = productPageService.getProductSpecifications(productId);
        //System.out.println(productId+"123123");// id
        System.out.println(specifications+"testtest");  //{1=顏色, 2=尺寸}  {8=顏色, 9=尺寸}
        if (!specifications.isEmpty()) {
            return new ResponseEntity<>(specifications, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/{productId}/specifications")
//    public ResponseEntity<ProductSpecifications> getProductSpecifications(@PathVariable Integer productId) {
//        ProductSpecifications productSpecifications = productPageService.getProductSpecifications(productId);
//
//        if (productSpecifications != null) {
//            return new ResponseEntity<>(productSpecifications, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    //    @RequestMapping("/04_product_page")
//    @ResponseBody
//    public List<Product> pp(){
//        //System.out.println(couponService.findAllCoupons()+"123123");
//        System.out.println("775578");
//        return productPageService.findAllProducts();
//    }

//    @GetMapping("/getModelInfo/{productId}")
//    public ResponseEntity<List<ModelInfo>> getModelInfoByProductId(@PathVariable Integer productId) {
//        List<ModelInfo> modelInfoList = productPageService.getModelInfoByProductId(productId);
//
//        if (!modelInfoList.isEmpty()) {
//            return new ResponseEntity<>(modelInfoList, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
