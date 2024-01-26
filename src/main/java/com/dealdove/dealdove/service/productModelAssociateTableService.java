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
    public productModelAssociateTableService(ProductModelAssociateTableRepository productModelAssociateTabletRepository) {
        this.productModelAssociateTableRepository = productModelAssociateTabletRepository;
    }

    public List<ProductModelAssociateTable> findAllProductModelAssociateTable() {
        return productModelAssociateTableRepository.findAll();
    }


    public void saveProductModelAssociateTable(String modelName) {

        ProductModelAssociateTable productModelAssociateTable = new ProductModelAssociateTable();
        productModelAssociateTable.setModelName(modelName);

        productModelAssociateTableRepository.save(productModelAssociateTable);
    }


    public List<ProductModelAssociateTable> getAllProductModelAssociateTable() {
        return productModelAssociateTableRepository.getAllProduct();
    }
}
