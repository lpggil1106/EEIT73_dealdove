package com.dealdove.dealdove.service;

import com.dealdove.dealdove.dao.ModelInfoRepository;
import com.dealdove.dealdove.model.ModelInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelInfoService {
    private ModelInfoRepository modelInfoRepository;

    @Autowired
    public ModelInfoService(ModelInfoRepository modelInfoRepository) {
        this.modelInfoRepository = modelInfoRepository;
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

