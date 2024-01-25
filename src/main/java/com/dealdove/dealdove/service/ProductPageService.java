package com.dealdove.dealdove.service;

import com.dealdove.dealdove.interfaces.ProductModelAssociateTableRepository;
import com.dealdove.dealdove.interfaces.ProductRepository;
import com.dealdove.dealdove.model.Product;
import com.dealdove.dealdove.model.ProductModelAssociateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductPageService {
    private ProductRepository productRepository;

    @Autowired
    public ProductPageService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
//    public List<Product> findAllProducts(){
//        return productRepository.findAllProducts();
//    }
    // 新增的方法，用於獲取特定商品的詳細資訊
    public Product getProductById(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }
//    public List<ModelInfo> getModelInfoByProductId(Integer productId) {
//        return productRepository.findModelInfoByProductId(productId);
//    }

    @Autowired
    private ProductModelAssociateTableRepository productModelAssociateTableRepository;

    public Map<String, Map<Integer, String>> getProductSpecifications(Integer productID) {
        List<ProductModelAssociateTable> specifications = productModelAssociateTableRepository.findByProductID(productID);
        System.out.println("hello"+specifications);
        Map<Integer, String> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        Map<Integer, String> map3 = new HashMap<>();
        Map<String,Map<Integer, String>> map4 = new HashMap<>();
        int datakey1=0;
        for (ProductModelAssociateTable spec : specifications) {
            if (spec.getParentModelID() == null) {
                if(datakey1==0){
                    datakey1=spec.getId();
                }
                map1.put(spec.getId(), spec.getModelName());
                map4.put("A",map1);
            }
        }

        for (ProductModelAssociateTable spec : specifications) {
            if (spec.getParentModelID() != null && datakey1==spec.getParentModelID() ) {
                map2.put(spec.getId(), spec.getModelName());
                map4.put("B",map2);
            }
            else if(spec.getParentModelID()!=null){
                map3.put(spec.getId(), spec.getModelName());
                map4.put("C",map3);
            }
        }
        return map4;

//        System.out.println("11M"+map1);
//        System.out.println("22M"+map2);
//        System.out.println("33M"+map3);
//        System.out.println("44M"+map4);
//        ProductSpecifications productSpecifications = new ProductSpecifications();
//        productSpecifications.setMap1(map1);
//        productSpecifications.setMap2(map2);
//        productSpecifications.setMap3(map3);


        // 在這裡根據情況判斷要返回哪個 Map
//        if (map1.size() == 1) {
//            // map1 的 key 只有一項
//            Map<Integer, String> result = new HashMap<>();
//            result.putAll(map1);
//            result.putAll(map2);
//            System.out.println(result);
//            return result;
//
//        } else if (map1.size() == 2) {
//            // map1 的 key 有兩項
//            Map<Integer, String> result = new HashMap<>();
//            result.putAll(map1);
//            result.putAll(map2);
//            result.putAll(map3);
//            System.out.println(result);
//            return result;
//        } else {
//            // 如果都是空的，表示沒有規格
//            return Collections.emptyMap();
//        }

    }
}
