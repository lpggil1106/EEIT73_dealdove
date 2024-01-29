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
    public String  addProduct(@RequestParam("productName") String productName,
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
//                                  @RequestParam("price1") Integer price1,
//                                  @RequestParam("quantity1") Integer quantity1,
//                                  @RequestParam("price2") Integer price2,
//                                  @RequestParam("quantity2") Integer quantity2,
//                                  @RequestParam("price3") Integer price3,
//                                  @RequestParam("quantity3") Integer quantity3,
//                                  @RequestParam("price4") Integer price4,
//                                  @RequestParam("price11") Integer price11,
//                                  @RequestParam("quantity11") Integer quantity11,
//                                  @RequestParam("price22") Integer price22,
//                                  @RequestParam("quantity22") Integer quantity22,
//                                  @RequestParam("price33") Integer price33,
//                                  @RequestParam("quantity33") Integer quantity33,
    //                              @RequestParam("price44") Integer price44,
    //                              @RequestParam("quantity44") Integer quantity44,
    //                              @RequestParam("price111") Integer price111,
    //                              @RequestParam("quantity111") Integer quantity111,
    //                              @RequestParam("price222") Integer price222,
    //                              @RequestParam("quantity222") Integer quantity222,
    //                              @RequestParam("price333") Integer price333,
    //                              @RequestParam("quantity333") Integer quantity333,
    //                              @RequestParam("price444") Integer price444,
    //                              @RequestParam("quantity444") Integer quantity444,
    //                              @RequestParam("price1111") Integer price1111,
    //                              @RequestParam("quantity1111") Integer quantity1111,
    //                              @RequestParam("price2222") Integer price2222,
    //                              @RequestParam("quantity2222") Integer quantity2222,
    //                              @RequestParam("price3333") Integer price3333,
    //                              @RequestParam("quantity3333") Integer quantity3333,
    //                              @RequestParam("price4444") Integer price4444,
    //                              @RequestParam("quantity4444") Integer quantity4444)

    {

        List<Product> allProducts = productService.saveProduct(productName, productDescription);

        addProductModelAssociateTable(specific);
        addProductModelAssociateTable(specific2);
        addProductModelAssociateTable(specific3);
        addProductModelAssociateTable(specific4);
        addProductModelAssociateTable(specific5);
        addProductModelAssociateTable(specific1);
        addProductModelAssociateTable(specific22);
        addProductModelAssociateTable(specific33);
        addProductModelAssociateTable(specific44);
        addProductModelAssociateTable(specific55);

        return "/10_seller_home_page.html";
    }


    @PostMapping("/add_productModelAssociateTable")
    public List<ProductModelAssociateTable> addProductModelAssociateTable(@RequestParam("modelName") String modelName) {

        // 如果 modelName 為null不儲存
        if (modelName != null && !modelName.isEmpty()) {
            productModelAssociateTableService.saveProductModelAssociateTable(modelName);
        }
        return productModelAssociateTableService.findAllProductModelAssociateTable();
    }

//    @PostMapping("/add_productModelAssociateTableChild")
//    public void addProductModelAssociateTableChild(String modelName, String parent) {
//        Integer x = productModelAssociateTableService.findByModelName(parent).getParentModelID();
//        // 如果 modelName 為null不儲存
//        if (modelName != null && !modelName.isEmpty()) {
//            productModelAssociateTableService.saveProductModelAssociateTable(modelName, x);
//        }
//    }


//    @PostMapping("/add_modelInfo")
//    public void addModelInfo(String modelInfo){
//        if(modelInfo != null){
//            modelInfoService.saveModelInfo(modelInfo);
//        }
//    }

}
