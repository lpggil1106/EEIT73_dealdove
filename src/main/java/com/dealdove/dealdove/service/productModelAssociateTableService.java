package com.dealdove.dealdove.service;

import com.dealdove.dealdove.dao.ProductModelAssociateTableRepository;
import com.dealdove.dealdove.model.ProductModelAssociateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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
