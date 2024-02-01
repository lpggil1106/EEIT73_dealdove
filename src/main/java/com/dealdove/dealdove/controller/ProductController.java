package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.dto.ProductHomeDTO;
import com.dealdove.dealdove.model.enitity.ModelInfo;
import com.dealdove.dealdove.model.enitity.Product;
import com.dealdove.dealdove.model.enitity.ProductModelAssociateTable;
import com.dealdove.dealdove.service.ModelInfoService;
import com.dealdove.dealdove.service.ProductService;
import com.dealdove.dealdove.service.ReviewService;
import com.dealdove.dealdove.service.productModelAssociateTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/10_seller_home_page")
public class ProductController {

    private final ProductService productService;
    private final productModelAssociateTableService productModelAssociateTableService;
    private final ModelInfoService modelInfoService;
    private final ReviewService reviewService;

    @Autowired
    public ProductController(ProductService productService,
                             productModelAssociateTableService productModelAssociateTableService,
                             ModelInfoService modelInfoService, ReviewService reviewService) {
        this.productService = productService;
        this.productModelAssociateTableService = productModelAssociateTableService;
        this.modelInfoService = modelInfoService;
        this.reviewService = reviewService;
    }




    @PostMapping("/add_product")
    public String addProduct(@RequestParam("productName") String productName,
                             @RequestParam("productDescription") String productDescription,
                             @RequestParam("categoryName") String categoryName,
                             @RequestParam("specific") String specific,
                             @RequestParam("specific2") String specific2,
                             @RequestParam("specific3") String specific3,
                             @RequestParam("specific4") String specific4,
                             @RequestParam("specific5") String specific5,
                             @RequestParam("specific1") String specific1,
                             @RequestParam("specific22") String specific22,
                             @RequestParam("specific33") String specific33,
                             @RequestParam("specific44") String specific44,
                             @RequestParam("specific55") String specific55,
                             @RequestParam("typedive1hidden") String typedive1hidden,
                             @RequestParam("typedive11hidden") String typedive11hidden,
                             @RequestParam("price1") Integer price,
                             @RequestParam("quantity1") Integer quantity)
    {


//        // 從 subCategory 參數找到對應的 categoryID
//        Integer productCategoryID = findCategoryIDByName(categoryName);

        // 創product實體
        Product product = productService.saveProduct(productName, productDescription,categoryName);
        // 獲得產品ID
        Integer productId = product.getProductID();

        //保存父模型與子模型
        productModelAssociateTableService.saveModelAndSubModels(specific, productId, specific2, specific3, specific4, specific5);
        productModelAssociateTableService.saveModelAndSubModels(specific1, productId, specific22, specific33, specific44, specific55);

        // 使用 productId 调用 service 方法来保存 ProductModelAssociateTable 和 ModelInfo
        productModelAssociateTableService.saveProductAndModelInfo(productId, typedive1hidden, typedive11hidden, price, quantity);
        // 返回
        return "redirect:/seller/10_seller_home_page.html";
    }



//    private void saveModelAndSubModels(String topModelName, Integer productId, String... subModelNames) {
//        if (topModelName != null && !topModelName.isEmpty()) {
//            // 保存父模型
//            ProductModelAssociateTable topModel = productModelAssociateTableService.saveProductModelAssociateTable(topModelName, productId, null);
//
//            // 检查並保存子模型
//            for (String subModelName : subModelNames) {
//                if (subModelName != null && !subModelName.isEmpty()) {
//                    productModelAssociateTableService.saveProductModelAssociateTable(subModelName, productId, topModel.getId());
//                }
//            }
//        }
//    }

    //    找到分類categoryID的方法
    private Integer findCategoryIDByName(String categoryName) {
        // 在這裡實現查詢邏輯，返回匹配的 categoryID
        return productService.findCategoryIDByName(categoryName);
    }

}