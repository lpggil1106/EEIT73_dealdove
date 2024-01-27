package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.Product;
import com.dealdove.dealdove.model.ProductModelAssociateTable;
import com.dealdove.dealdove.service.ProductService;
import com.dealdove.dealdove.service.productModelAssociateTableService;
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
    private productModelAssociateTableService productModelAssociateTableService;
    @Autowired
    public ProductController(ProductService productService, productModelAssociateTableService productModelAssociateTableService) {
        this.productService = productService;
        this.productModelAssociateTableService = productModelAssociateTableService;
    }

    @PostMapping("/add_product")
    public List<Product> addProduct(@RequestParam("productName") String productName,
                                    @RequestParam("productDescription") String productDescription,
                                    @RequestParam("specific") String specific,
                                    @RequestParam("specific2") String specific2,
                                    @RequestParam("specific3") String specific3,
                                    @RequestParam("specific4") String specific4,
                                    @RequestParam("specific5") String specific5)

    {
        // 分別將 modelName1 和 modelName2 存儲到數據庫的不同行
        List<Product> allProducts = productService.saveProduct(productName, productDescription);
        List<ProductModelAssociateTable> allProductModelAssociations1 = addProductModelAssociateTable(specific);
        List<ProductModelAssociateTable> allProductModelAssociations2 = addProductModelAssociateTable(specific2);
        List<ProductModelAssociateTable> allProductModelAssociations3 = addProductModelAssociateTable(specific3);
        List<ProductModelAssociateTable> allProductModelAssociations4 = addProductModelAssociateTable(specific4);
        List<ProductModelAssociateTable> allProductModelAssociations5 = addProductModelAssociateTable(specific5);
        return allProducts;
    }

    @PostMapping("/add_productModelAssociateTable")
    public List<ProductModelAssociateTable> addProductModelAssociateTable(@RequestParam("modelName") String modelName) {


        productModelAssociateTableService.saveProductModelAssociateTable(modelName);
        return productModelAssociateTableService.findAllProductModelAssociateTable();
    }

}
