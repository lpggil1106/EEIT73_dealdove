package com.dealdove.dealdove.model.enitity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Data
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
}