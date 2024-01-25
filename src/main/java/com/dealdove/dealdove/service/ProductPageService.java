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

    public Product getProductById(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }

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

    }
}
