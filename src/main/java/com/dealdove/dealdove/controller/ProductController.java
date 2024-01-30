package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.ModelInfo;
import com.dealdove.dealdove.model.Product;
import com.dealdove.dealdove.model.ProductModelAssociateTable;
import com.dealdove.dealdove.service.ModelInfoService;
import com.dealdove.dealdove.service.ProductService;
import com.dealdove.dealdove.service.productModelAssociateTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/10_seller_home_page")
public class ProductController {

    private ProductService productService;
    private productModelAssociateTableService productModelAssociateTableService;

    private ModelInfoService modelInfoService;

    @Autowired
    public ProductController(ProductService productService, productModelAssociateTableService productModelAssociateTableService, ModelInfoService modelInfoService) {
        this.productService = productService;
        this.productModelAssociateTableService = productModelAssociateTableService;
        this.modelInfoService = modelInfoService;
    }


    @PostMapping("/add_product")
    public String addProduct(@RequestParam("productName") String productName,
                             @RequestParam("productDescription") String productDescription,
                             @RequestParam("specific") String specific,
                             @RequestParam("specific2") String specific2,
                             @RequestParam("specific3") String specific3,
                             @RequestParam("specific4") String specific4,
                             @RequestParam("specific5") String specific5,
                             @RequestParam("specific1") String specific1,
                             @RequestParam("specific22") String specific22,
                             @RequestParam("specific33") String specific33,
                             @RequestParam("specific44") String specific44,
                             @RequestParam("specific55") String specific55)


    {
        // 創產品實體
        Product product = productService.saveProduct(productName, productDescription);
        // 獲得產品ID
        Integer productId = product.getProductID();

        //保存父模型與子模型
        saveModelAndSubModels(specific, productId, specific2, specific3, specific4, specific5);
        saveModelAndSubModels(specific1, productId, specific22, specific33, specific44, specific55);

        // 假設 parentModelIDa 和 parentModelIDb 是已知的
        Integer parentModelIDa =1; // 待定
        Integer parentModelIDb = 2; //

        // 創建 ModelInfo 實例
        modelInfoService.createModelInfosForProduct(productId, parentModelIDa, parentModelIDb);

        // 返回页面路径
        return "redirect:/10_seller_home_page.html";
    }

    private void saveModelAndSubModels(String topModelName, Integer productId, String... subModelNames) {
        if (topModelName != null && !topModelName.isEmpty()) {
            // 保存父模型
            ProductModelAssociateTable topModel = productModelAssociateTableService.saveProductModelAssociateTable(topModelName, productId, null);

            // 检查並保存子模型
            for (String subModelName : subModelNames) {
                if (subModelName != null && !subModelName.isEmpty()) {
                    productModelAssociateTableService.saveProductModelAssociateTable(subModelName, productId, topModel.getId());
                }
            }
        }
    }
}