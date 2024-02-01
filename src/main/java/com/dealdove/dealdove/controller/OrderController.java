package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/showOrderName")
    public List<HashMap<String,String>> getOrderItemsByOrderID(@RequestBody LinkedHashMap<String, String> user) {
//        orderService.findOrderByBuyerIDAndStaus2(user);
        return orderService.getOrderItemsNameByOrderID(user);

    }


//    @PostMapping("/showOrderQuantity")
//    public List<String> getOrderItemsQuantityByOrderID(@RequestBody LinkedHashMap<String, String> user) {
//        return orderService.getOrderItemsQuantityByOrderID(user);
//    }
    @CrossOrigin(origins = "*",maxAge = 3600)
    @PostMapping("/ecpayCheckout")
    public String ecpayCheckout() {
        String aioCheckOutALLForm = orderService.ecpayCheckout();
        return  aioCheckOutALLForm;
//        return "{\"form\":\""+aioCheckOutALLForm+"\"}";
    }

//    遊戲直接結束
    @PostMapping("/ecpayMapChoosing")
    public String ecpayMapChoosing() {
        String map = orderService.ecpayMap("Dylan", "0978095607");
        return map;
    }

    @PostMapping("/submitOrder")
    public String submitOrder(OrderService.OrderForm orderForm) {

        return "orderConfirmation"; // 訂單確認頁面
    }

}

