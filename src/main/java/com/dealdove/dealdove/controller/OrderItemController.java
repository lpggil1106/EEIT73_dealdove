package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.OrderItem;
import com.dealdove.dealdove.model.Product;
import com.dealdove.dealdove.service.OrderItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderItemController {

    OrderItemService orderItemService;
    public OrderItemController(OrderItemService orderItemService){
        this.orderItemService=orderItemService;
    }

//    @GetMapping("/orderItem")
//    public void findOrderItemByID(){
//        List<OrderItem> orderItemsList = orderItemService.findOrderItemByOrderItemID(1);
//        OrderItem orderItems = orderItemsList.get(0);
//        System.out.println(orderItems);
//        Product product = orderItems.getProduct();
//        System.out.println(product.getProductName());
//    }
}
