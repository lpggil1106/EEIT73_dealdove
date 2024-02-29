package com.dealdove.dealdove.model.enitity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "productCategory", schema = "dealdove")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryID", nullable = false)
    private Integer id;

    @Column(name = "categoryName", nullable = false, length = 500)
    private String categoryName;

    @Column(name = "parentCategoryID")
    private Integer parentCategoryID;


}