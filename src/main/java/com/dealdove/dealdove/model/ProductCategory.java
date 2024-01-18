package com.dealdove.dealdove.model;

import jakarta.persistence.*;

@Entity
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getParentCategoryID() {
        return parentCategoryID;
    }

    public void setParentCategoryID(Integer parentCategoryID) {
        this.parentCategoryID = parentCategoryID;
    }

}