package com.dealdove.dealdove.model.enitity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "applicableCategoriesAssociationTable")
public class ApplicableCategoriesAssociationTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicableCategoriesID", nullable = false, unique = true)
    private Integer applicableCategoriesID;

    @Column(name = "couponID", nullable = false)
    private Integer couponID;

    @Column(name = "categoriesID", nullable = false)
    private Integer categoriesID;
}
