package com.dealdove.dealdove.controller;


import com.dealdove.dealdove.model.ModelInfo;
import com.dealdove.dealdove.model.Product;
import com.dealdove.dealdove.service.ProductPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class productPageController {
    @Autowired
    private ProductPageService productPageService;

    @GetMapping("/getProduct/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer productId) {
        Product product = productPageService.getProductById(productId);
        // 如果找到商品，返回該商品的資訊和 HTTP 狀態碼 200 OK
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            // 如果商品不存在，返回 HTTP 狀態碼 404 NOT FOUND
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{productId}/specifications")
    public ResponseEntity<Map<String, Object>> getProductSpecifications(@PathVariable Integer productId) {
        Map<String, Object>  specifications = productPageService.getProductSpecifications(productId);

        if (!specifications.isEmpty()) {
            return new ResponseEntity<>(specifications, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{productid}/{firstModelid}/{secondModelid}/modelinfo")
    public ResponseEntity<ModelInfo> findModelInfoByProductIDAndFirstModelIDAndSecondModelID(@PathVariable Integer productid, @PathVariable Integer firstModelid, @PathVariable Integer secondModelid){
        ModelInfo modelinfo = productPageService.findModelInfoByProductIDAndFirstModelIDAndSecondModelID(productid, firstModelid, secondModelid);
        if(modelinfo != null){
            return new  ResponseEntity<>(modelinfo, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
