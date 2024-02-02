package com.dealdove.dealdove.model.dao;



import com.dealdove.dealdove.model.dto.ProductHomeDTO;
import com.dealdove.dealdove.model.enitity.Product;
import com.dealdove.dealdove.model.enitity.ProductImageTable;
import com.google.firebase.internal.NonNull;


import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
//@SqlResultSetMapping(
//        name = "ProductHomeDTOMapping",
//        classes = @ConstructorResult(
//                targetClass = ProductHomeDTO.class,
//                columns = {
//                        @ColumnResult(name = "productID", type = Integer.class),
//                        @ColumnResult(name = "productName", type = String.class),
//                        @ColumnResult(name = "minPrice", type = Integer.class),
//                        @ColumnResult(name = "maxPrice", type = Integer.class),
//                        @ColumnResult(name = "avgRating", type = Double.class),
//                        @ColumnResult(name = "coverImageURL", type = String.class)
//                }
//        )
//)
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


    @Query(value = "WITH ProductImagesRanked AS (\n" +
            "    SELECT\n" +
            "        pi.productID,\n" +
            "        pi.image,\n" +
            "        ROW_NUMBER() OVER (PARTITION BY pi.productID ORDER BY pi.image) AS ImageRank\n" +
            "    FROM\n" +
            "        productImageTable pi\n" +
            ")\n" +
            "SELECT\n" +
            "    p.productID,\n" +
            "    p.productName,\n" +
            "    MIN(mi.price) AS minPrice,\n" +
            "    MAX(mi.price) AS maxPrice,\n" +
            "    AVG(r.rating) AS avgRating,\n" +
            "    pir.image AS coverImageURL\n" +
            "    ,p.soldQuantity AS soldQuantity\n" +
            "FROM\n" +
            "    product p\n" +
            "        JOIN\n" +
            "    modelInfo mi ON p.productID = mi.productID\n" +
            "        LEFT JOIN\n" +
            "    review r ON p.productID = r.productID\n" +
            "        LEFT JOIN\n" +
            "    ProductImagesRanked pir ON p.productID = pir.productID AND pir.ImageRank = 1\n" +
            "GROUP BY\n" +
            "    p.productID, p.productName, pir.image;", nativeQuery = true)
    List<Object[]> getProductDetails();

    @Query(value = "WITH ProductImagesRanked AS (\n" +
            "    SELECT\n" +
            "        pi.productID,\n" +
            "        pi.image,\n" +
            "        ROW_NUMBER() OVER (PARTITION BY pi.productID ORDER BY pi.image) AS ImageRank\n" +
            "    FROM\n" +
            "        productImageTable pi\n" +
            ")\n" +
            "SELECT\n" +
            "    p.productID,\n" +
            "    p.productName,\n" +
            "    MIN(mi.price) AS minPrice,\n" +
            "    MAX(mi.price) AS maxPrice,\n" +
            "    AVG(r.rating) AS avgRating,\n" +
            "    pir.image AS coverImageURL,\n" +
            "    p.soldQuantity AS soldQuantity\n" +
            "FROM\n" +
            "    product p\n" +
            "        JOIN\n" +
            "    modelInfo mi ON p.productID = mi.productID\n" +
            "        LEFT JOIN\n" +
            "    review r ON p.productID = r.productID\n" +
            "        LEFT JOIN\n" +
            "    ProductImagesRanked pir ON p.productID = pir.productID AND pir.ImageRank = 1\n" +
            "WHERE\n" +
            "    p.productName LIKE %:keyword% OR p.productDescription LIKE %:keyword%\n" +
            "GROUP BY\n" +
            "    p.productID, p.productName, pir.image;", nativeQuery = true)
    List<Object[]> getProductDetailsByKeyword(@Param("keyword") String keyword);



    // 添加一個新的查詢方法來獲取特定productID的productName
    @Query("SELECT p.productName FROM Product p WHERE p.productID = :productID")
    String findProductNameById(@Param("productID") int productID);

    @Query(value = "SELECT * FROM product WHERE productID = 1 ", nativeQuery = true)
    List<Product> findProduct();

    @Query(value = "SELECT * FROM product",nativeQuery = true)
    List<Product> getAllProduct();

    @Query(value = "SELECT * FROM productCategory",nativeQuery = true)
    List<Product> findAllproductCategory();

    @NonNull
    List<Product> findAll();

    List<Product> findByProductID(int productID);

    @Query(value = "SELECT * FROM product WHERE productID = :productId", nativeQuery = true)
    List<Product> findProductByProductId(@Param("productId") int productId);

    List<ProductImageTable> findALLByProductID(Integer ProductID);

    Product findProductByproductID(Integer productID);

//    List<Product> findByProductNameOrProductDescription(String keyword);

    Product save(Product product);

    @Query(value = "SELECT * FROM product WHERE productID = :productId" , nativeQuery = true)
    List<Product> getProductByID(@Param("productId") int productId);
}
