package com.dealdove.dealdove.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderID", nullable = false)
    private Integer orderID;

//    一對多 獲取多個外鍵為orderID的orderItem對象
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
//    @JoinColumn(name = "orderID")
    private List<OrderItem> orderItems;

//    @ManyToOne
//    @JoinColumn(name = "userID", nullable = false)
//    private User user;

    @Column(name = "sellerID", nullable = false)
    private String sellerID;

    @Column(name = "buyerID", nullable = false)
    private String buyerID;

    @Column(name = "paymentID", nullable = false)
    private Integer paymentID;

    @Column(name = "couponID")
    private Integer couponID;

    @Column(name = "buyerComment", length = 300)
    private String buyerComment;

    @Column(name = "sellerComment", length = 300)
    private String sellerComment;

    @Column(name = "orderStatus", nullable = false)
    private Byte orderStatus;

    @Column(name = "orderDate", nullable = false)
    private ZonedDateTime orderDate;

    @Column(name = "totalPrice", nullable = false)
    private Integer totalPrice;

    @Column(name = "shippingAddress", nullable = false, length = 100)
    private String shippingAddress;

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", orderItems=" + orderItems +
                ", sellerID='" + sellerID + '\'' +
                ", buyerID='" + buyerID + '\'' +
                ", paymentID=" + paymentID +
                ", couponID=" + couponID +
                ", buyerComment='" + buyerComment + '\'' +
                ", sellerComment='" + sellerComment + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderDate=" + orderDate +
                ", totalPrice=" + totalPrice +
                ", shippingAddress='" + shippingAddress + '\'' +
                '}';
    }
}