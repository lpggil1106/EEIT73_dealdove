package com.dealdove.dealdove.service;

import com.dealdove.dealdove.model.dao.ProductModelAssociateTableRepository;
import com.dealdove.dealdove.model.enitity.ModelInfo;
import com.dealdove.dealdove.model.enitity.Product;
import com.dealdove.dealdove.model.enitity.ProductModelAssociateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class productModelAssociateTableService {

    private final ProductModelAssociateTableRepository productModelAssociateTableRepository;
    private final ProductService productService; // 确保 ProductService 被注入
    private final ModelInfoService modelInfoService; // 确保 ModelInfoService 被注入

    @Autowired
    public productModelAssociateTableService(ProductModelAssociateTableRepository productModelAssociateTableRepository,
                                             ProductService productService, // 构造器注入 ProductService
                                             ModelInfoService modelInfoService) { // 构造器注入 ModelInfoService
        this.productModelAssociateTableRepository = productModelAssociateTableRepository;
        this.productService = productService;
        this.modelInfoService = modelInfoService;
    }

    public void saveModelAndSubModels(String topModelName, Integer productId, String... subModelNames) {
        if (topModelName != null && !topModelName.isEmpty()) {
            // 保存父模型
            ProductModelAssociateTable topModel = saveProductModelAssociateTable(topModelName, productId, null);

            // 检查并保存子模型
            for (String subModelName : subModelNames) {
                if (subModelName != null && !subModelName.isEmpty()) {
                    saveProductModelAssociateTable(subModelName, productId, topModel.getId());
                }
            }
        }
    }
    public void saveProductAndModelInfo(Integer productId,
                                        String typedive1hidden, String typedive11hidden, Integer price, Integer quantity) {
        // 首先保存 Product


        // 在 ProductModelAssociateTable 保存后，查找 firstModelID 和 secondModelID
        Integer firstModelID = findModelIdByModelNameAndProductId(typedive1hidden, productId);
        Integer secondModelID = findModelIdByModelNameAndProductId(typedive11hidden, productId);

        // 创建 ModelInfo 实体并保存
        ModelInfo modelInfo = new ModelInfo();
        modelInfo.setProductID(productId);
        modelInfo.setFirstModelID(firstModelID);
        modelInfo.setSecondModelID(secondModelID);
        modelInfo.setPrice(price);
        modelInfo.setQuantity(quantity);
        modelInfoService.saveModelInfo(modelInfo); // 确保存在 modelInfoService
    }
    public List<ProductModelAssociateTable> findAllProductModelAssociateTable() {
        return productModelAssociateTableRepository.findAll();
    }

    public ProductModelAssociateTable saveProductModelAssociateTable(String modelName, Integer productID, Integer parentModelID) {
        ProductModelAssociateTable productModelAssociateTable = new ProductModelAssociateTable();
        productModelAssociateTable.setModelName(modelName);
        productModelAssociateTable.setProductID(productID);
        productModelAssociateTable.setParentModelID(parentModelID);
        return productModelAssociateTableRepository.save(productModelAssociateTable);
    }


    public ProductModelAssociateTable findByModelName(String modelName){
        return productModelAssociateTableRepository.findByModelName(modelName);
    }


    public List<ProductModelAssociateTable> getAllProductModelAssociateTable() {
        return productModelAssociateTableRepository.getAllProduct();
    }


    public Integer findModelIdByModelNameAndProductId(String modelName, Integer productID) {
        ProductModelAssociateTable model = productModelAssociateTableRepository.findByModelNameAndProductID(modelName, productID);
        if (model != null) {
            return model.getId();
        } else {
            return null;
        }
    }
}