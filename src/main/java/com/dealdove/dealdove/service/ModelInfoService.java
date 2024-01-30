package com.dealdove.dealdove.service;

import ch.qos.logback.core.model.Model;
import com.dealdove.dealdove.dao.ModelInfoRepository;
import com.dealdove.dealdove.dao.ProductModelAssociateTableRepository;
import com.dealdove.dealdove.model.ModelInfo;
import com.dealdove.dealdove.model.ProductModelAssociateTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ModelInfoService {
    private final Logger log = LoggerFactory.getLogger(ModelInfoService.class);
    private ModelInfoRepository modelInfoRepository;
    private ProductModelAssociateTableRepository productModelAssociateTableRepository;


    @Autowired
    public ModelInfoService(ModelInfoRepository modelInfoRepository,
                            ProductModelAssociateTableRepository productModelAssociateTableRepository) {
        this.modelInfoRepository = modelInfoRepository;
        this.productModelAssociateTableRepository = productModelAssociateTableRepository;
    }
    public void createModelInfosForProduct(Integer productID, Integer parentModelIDa, Integer parentModelIDb) {
        List<ProductModelAssociateTable> allModels = productModelAssociateTableRepository.findByProductID(productID);
        log.info("找到 {} 個模型关联", allModels.size());

        // 將模型按 parentModelID 分組
        Map<Integer, List<ProductModelAssociateTable>> modelGroups = allModels.stream()
                .filter(model -> model.getParentModelID() != null) // 只處理 parentModelID 不為 null 的模型
                .collect(Collectors.groupingBy(ProductModelAssociateTable::getParentModelID));

        // 獲取屬於 parentModelIDa 和 parentModelIDb 的子模型清單
        List<ProductModelAssociateTable> modelsOfGroupA = modelGroups.get(parentModelIDa);
        List<ProductModelAssociateTable> modelsOfGroupB = modelGroups.get(parentModelIDb);

        // 檢查是否存在對應的模型組
        if (modelsOfGroupA != null && modelsOfGroupB != null) {
            log.info("找到 A 组 {} 个子模型, B 组 {} 个子模型", modelsOfGroupA.size(), modelsOfGroupB.size());
            for (ProductModelAssociateTable modelA : modelsOfGroupA) {
                for (ProductModelAssociateTable modelB : modelsOfGroupB) {
                    // 创建 ModelInfo 实例
                    ModelInfo modelInfo = new ModelInfo();
                    modelInfo.setProductID(productID);
                    modelInfo.setFirstModelID(modelA.getId());
                    modelInfo.setSecondModelID(modelB.getId());
                    // TODO: 设置 price 和 quantity
                    // ...

                    ModelInfo savedModelInfo = modelInfoRepository.save(modelInfo);
//                    log.info("保存 ModelInfo，ID: {}", savedModelInfo.getModelInfoID());
                }
            }
        } else {
            log.warn("A 组或 B 组的子模型为空");
        }
    }


    public String getMaxMinPrice(Integer productID){
        //最小值
        int Max = Integer.MIN_VALUE;
        int Min = Integer.MAX_VALUE;

        //建造表單
        List<ModelInfo> list = modelInfoRepository.findByProductID(productID);

        //遍歷表單
        for (ModelInfo modelInfo : list) {
            System.out.println(modelInfo.getPrice());
            int price = modelInfo.getPrice();

            if(price > Max){
                Max = modelInfo.getPrice();
            }

            if(price < Min){
                Min = modelInfo.getPrice();
            }
        }

        if(Max == Min){
            return "$" + Integer.toString(Max);
        }else{
            return "$" + Integer.toString(Min) + " ~ $" + Integer.toString(Max);
        }
    }
}

