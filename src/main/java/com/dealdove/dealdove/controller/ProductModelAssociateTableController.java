//package com.dealdove.dealdove.controller;
//
//import com.dealdove.dealdove.model.Product;
//import com.dealdove.dealdove.model.ProductCategory;
//import com.dealdove.dealdove.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/10_seller_home_page")
//public class ProductModelAssociateTableController {
//
//    private ProductModelAssociateTableService productModelAssociateTableService;
//
//    @Autowired
//    public ProductModelAssociateTableController(ProductModelAssociateTableService productModelAssociateTableService) {
//        this.productModelAssociateTableService = productModelAssociateTableService;
//    }
//
//
//
//    @PostMapping("/add_productModelAssociateTable")
//    public List<ProductCategory> addProductModelAssociateTable(
//
//                                    @RequestParam("modelName") String modelName)
//
//    {
//
//        productModelAssociateTableService.saveProductModelAssociateTable(modelName);
//
//
//        return productModelAssociateTableService.findAllProductCategories();
//    }
//
//
//
//}
