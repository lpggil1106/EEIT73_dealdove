package com.dealdove.dealdove.service;

import com.dealdove.dealdove.dao.ProductModelAssociateTableRepository;
import com.dealdove.dealdove.model.ProductModelAssociateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productModelAssociateTableService {

    private ProductModelAssociateTableRepository productModelAssociateTableRepository;

    @Autowired
    public productModelAssociateTableService(ProductModelAssociateTableRepository productModelAssociateTableRepository) {
        this.productModelAssociateTableRepository = productModelAssociateTableRepository;
    }

    public List<ProductModelAssociateTable> findAllProductModelAssociateTable() {
        return productModelAssociateTableRepository.findAll();
    }

    public ProductModelAssociateTable saveProductModelAssociateTable(String modelName, Integer productID, Integer parentModelID) {
        ProductModelAssociateTable productModelAssociateTable = new ProductModelAssociateTable();
        productModelAssociateTable.setModelName(modelName);
        productModelAssociateTable.setProductID(productID); // 设置 productID
        productModelAssociateTable.setParentModelID(parentModelID); // 设置 parentModelID
        return productModelAssociateTableRepository.save(productModelAssociateTable);
    }


    public ProductModelAssociateTable findByModelName(String modelName){
        return productModelAssociateTableRepository.findByModelName(modelName);
    }

    public List<ProductModelAssociateTable> getAllProductModelAssociateTable() {
        return productModelAssociateTableRepository.getAllProduct();
    }
}
