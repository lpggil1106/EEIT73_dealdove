package com.dealdove.dealdove.controller;


import com.dealdove.dealdove.model.ModelInfo;
import com.dealdove.dealdove.service.ProductPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class productPageController {
    @Autowired
    private ProductPageService productPageService;

    @GetMapping("/getProduct/{productId}")
    public List<HashMap<String, String>> getProductById(@PathVariable Integer productId) {
        return productPageService.getProductById(productId);
    }
    @GetMapping("/{productId}/specifications")
    public Map<String, Object> getProductSpecifications(@PathVariable Integer productId) {
        System.out.println(productPageService.getProductById(productId)+"_spec_controller__");
        return productPageService.getProductSpecifications(productId);
    }
    @GetMapping("/{productid}/{firstModelid}/{secondModelid}/modelinfo")
    public ModelInfo findModelInfoByProductIDAndFirstModelIDAndSecondModelID(@PathVariable Integer productid, @PathVariable Integer firstModelid, @PathVariable Integer secondModelid){
        return  productPageService.findModelInfoByProductIDAndFirstModelIDAndSecondModelID(productid, firstModelid, secondModelid);
    }
}
