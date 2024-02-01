package com.dealdove.dealdove.service;

import com.dealdove.dealdove.model.dao.ModelInfoRepository;
import com.dealdove.dealdove.model.dao.ProductModelAssociateTableRepository;
import com.dealdove.dealdove.model.enitity.ModelInfo;
import com.dealdove.dealdove.model.enitity.ProductModelAssociateTable;
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


    public void saveModelInfo(ModelInfo modelInfo){
        modelInfoRepository.save(modelInfo);
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

