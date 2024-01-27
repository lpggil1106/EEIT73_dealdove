package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.Order;
import com.dealdove.dealdove.model.OrderItem;
import com.dealdove.dealdove.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    private OrderService orderService;
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }
@PostMapping("/showOrderName")
public List<String> getOrderItemsByOrderID(@RequestBody LinkedHashMap<String, String> user) {
        return orderService.getOrderItemsNameByOrderID(user);
}
@PostMapping("/showOrderQuantity")
    public  List<String> getOrderItemsQuantityByOrderID(@RequestBody LinkedHashMap<String, String> user){
        return orderService.getOrderItemsQuantityByOrderID(user);
}

    }
//}
