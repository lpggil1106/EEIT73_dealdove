package com.dealdove.dealdove.service;

import com.dealdove.dealdove.dao.ModelInfoRepository;
import com.dealdove.dealdove.dao.ProductModelAssociateTableRepository;
import com.dealdove.dealdove.dao.ProductRepository;
import com.dealdove.dealdove.model.ModelInfo;
import com.dealdove.dealdove.model.Product;
import com.dealdove.dealdove.model.ProductModelAssociateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductPageService {
    private ProductRepository productRepository;
    @Autowired
    private ProductModelAssociateTableRepository productModelAssociateTableRepository;
    @Autowired
    private ModelInfoRepository modelInfoRepository;

    @Autowired
    public ProductPageService(ProductRepository productRepository){

        this.productRepository = productRepository;
    }

    public ProductPageService(ProductModelAssociateTableRepository productModelAssociateTableRepository) {
        this.productModelAssociateTableRepository = productModelAssociateTableRepository;
    }

    public Product getProductById(Integer productId) {

        return productRepository.findById(productId).orElse(null);
    }
    public ProductPageService(ModelInfoRepository modelInfoRepository){
        this.modelInfoRepository = modelInfoRepository;
    }
    public ModelInfo findModelInfoByProductIDAndFirstModelIDAndSecondModelID(Integer productid, Integer firstModelid, Integer secondModelid){
        return modelInfoRepository.findModelInfoByProductIDAndFirstModelIDAndSecondModelID(productid, firstModelid, secondModelid);

    }
    public Map<String, Object> getProductSpecifications(Integer productID) {
        List<ProductModelAssociateTable> specifications = productModelAssociateTableRepository.findByProductID(productID);
        Map<String, Object> map1 = new LinkedHashMap<>();
        int datakey1 = 0; //要抓 顏色跟尺寸id來比對 datakey1=spec.getId();
        int loop = 0;  //記錄迴圈數
        for (ProductModelAssociateTable spec : specifications) {
            if (spec.getParentModelID() == null) {
                datakey1 = spec.getId();

                Map<String, Object> newMap = new LinkedHashMap<String, Object>();
                newMap.put("id", spec.getId().toString());
                newMap.put("name", spec.getModelName());

                List<Map<String, Object>> dataMapList = new ArrayList<Map<String, Object>>();
                for (ProductModelAssociateTable dataspec : specifications) {
                    if (dataspec.getParentModelID() != null && datakey1 == dataspec.getParentModelID()) {
                        Map<String, Object> dataSpec = new LinkedHashMap<>();
                        dataSpec.put("id", dataspec.getId());
                        dataSpec.put("name", dataspec.getModelName());
                        dataMapList.add(dataSpec);
                    }
                }
                newMap.put("dataMapList", dataMapList);

                if (!dataMapList.isEmpty()) { //有明細才算一組"map"
                    loop++; // 0為第一圈需為map1， ++表示+1
                    map1.put("map" + loop, newMap);
                }
            }
        }
        //System.out.print(map1);
        //{map1={id=8, name=顏色, dataMapList=[{id=10, name=黑色}, {id=11, name=白色}]},
        // map2={id=9, name=尺寸, dataMapList=[{id=12, name=S}, {id=13, name=M}, {id=14, name=L}]}}

        return map1;
    }
}