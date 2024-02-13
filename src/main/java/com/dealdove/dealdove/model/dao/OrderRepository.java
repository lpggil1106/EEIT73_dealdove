package com.dealdove.dealdove.model.dao;

import com.dealdove.dealdove.model.enitity.Order;
import com.dealdove.dealdove.model.enitity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT * FROM `order` WHERE buyerID= :buyerID", nativeQuery = true)
    List<Order> findAllOrders(@Param("buyerID") String buyerID);

    @Query(value = "SELECT * FROM `order` WHERE buyerID= :buyerID AND orderStatus= :orderStatus",nativeQuery = true)
    List<Order> findOrderByBuyerIDAndStatus(@Param("buyerID") String buyerID,@Param("orderStatus") int orderStatus);

    @Query(value = """
            SELECT oi.quantity, p.productName, oi.model, pIT.image\s
            FROM orderItem oi
            JOIN `order` o ON oi.orderID = o.orderID
            JOIN product p ON oi.productID = p.productID
            JOIN productImageTable pIT ON p.productID = pIT.productID
            WHERE o.buyerID = :buyerID AND o.orderStatus = :orderStatus
            ORDER BY oi.orderID\s
            LIMIT :start, :end""",nativeQuery = true)
    List<Object[]> findOrderByBuyerIDAndStatus2(@Param("buyerID") String buyerID,@Param("orderStatus") int orderStatus,
                                            @Param("start")int start,@Param("end")int end);

    Order save(Order order);

    @Query(value = "WITH ProductImagesRanked AS (\n" +
            "    SELECT\n" +
            "        pi.productID,\n" +
            "        pi.image,\n" +
            "        ROW_NUMBER() OVER (PARTITION BY pi.productID ORDER BY pi.image) AS ImageRank\n" +
            "    FROM\n" +
            "        productImageTable pi\n" +
            ")\n" +
            "SELECT\n" +
            "    u.userName,\n" +
            "    o.buyerID,\n" +
            "    o.orderID,\n" +
            "    p.productName,\n" +
            "    oi.quantity,\n" +
            "    oi.model,\n" +
            "    o.totalPrice,\n" +
            "    o.orderStatus,\n" +
            "    o.shippingAddress,\n" +
            "    pir.image AS coverImageURL\n" +
            "FROM\n" +
            "    `order` o\n" +
            "        JOIN\n" +
            "    user u ON o.buyerID = u.userID\n" +
            "        JOIN\n" +
            "    orderItem oi ON o.orderID = oi.orderID\n" +
            "        JOIN\n" +
            "    product p ON oi.productID = p.productID\n" +
            "        LEFT JOIN\n" +
            "    ProductImagesRanked pir ON p.productID = pir.productID AND pir.ImageRank = 1\n" +
            "WHERE\n" +
            "    o.sellerID = :sellerID ;\n",nativeQuery = true)
    List<Object[]> findOrderBySellerID(@Param("sellerID") String sellerID);

}


