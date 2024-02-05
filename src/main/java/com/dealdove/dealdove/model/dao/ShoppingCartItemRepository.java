package com.dealdove.dealdove.model.dao;

import com.dealdove.dealdove.model.enitity.ShoppingCartItem;
import com.dealdove.dealdove.model.enitity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, String> {
    List<ShoppingCartItem> findByUserID(String userID);

    @Query(value = "WITH ProductImagesRanked AS (\n" +
            "    SELECT\n" +
            "        pi.productID,\n" +
            "        pi.image,\n" +
            "        ROW_NUMBER() OVER (PARTITION BY pi.productID ORDER BY pi.image) AS ImageRank\n" +
            "    FROM\n" +
            "        productImageTable pi\n" +
            ")\n" +
            "SELECT\n" +
            "    sc.shoppingCartItemID,\n" +
            "    pir.image AS coverImageURL,\n" +
            "    p.productName,\n" +
            "    sc.models,\n" +
            "    sc.price\n," +
            "    sc.quantity\n,"+
            "    p.userID\n,"+
            "    u.userName\n"+
            "FROM\n" +
            "    shoppingCartItem sc\n" +
            "        JOIN\n" +
            "    dealdove.product p on sc.productID = p.productID\n" +
            "        LEFT JOIN\n" +
            "    review r ON p.productID = r.productID\n" +
            "        LEFT JOIN\n" +
            "    ProductImagesRanked pir ON p.productID = pir.productID AND pir.ImageRank = 1\n" +
            "        LEFT JOIN\n" +
            "    user u ON p.userID = u.userID\n" +
            "WHERE sc.userID = :userID\n" +
            "GROUP BY\n" +
            "    p.productID, p.productName, pir.image, p.userID;",nativeQuery = true)
    List<Object[]> findCheckoutDetailByUserID(@Param("userID") String userID);




    // 透過 productID 和 userID 刪除購物車項目
    @Transactional
    void deleteByShoppingCartItemID(Integer ShoppingCartItemID);

    @Modifying
    @Transactional
    @Query("UPDATE ShoppingCartItem sc SET sc.quantity = :quantity WHERE sc.shoppingCartItemID = :shoppingCartItemID")
    void updateQuantityByShoppingCartItemID(@Param("shoppingCartItemID") Integer shoppingCartItemID, @Param("quantity") Integer quantity);

}
