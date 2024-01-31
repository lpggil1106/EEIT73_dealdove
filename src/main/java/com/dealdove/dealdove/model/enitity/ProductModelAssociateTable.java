package com.dealdove.dealdove.model.enitity;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;

@Entity

@Table(name = "productModelAssociateTable", schema = "dealdove")
public class ProductModelAssociateTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productModelID", nullable = false)
    private Integer id;

    @Column(name = "productID", nullable = true)
    private Integer productID;

    @Column(name = "modelName", nullable = true, length = 40)
    private String modelName;

    @Column(name = "parentModelID")
    private Integer parentModelID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Integer getParentModelID() {
        return parentModelID;
    }

    public void setParentModelID(Integer parentModelID) {
        this.parentModelID = parentModelID;
    }

}