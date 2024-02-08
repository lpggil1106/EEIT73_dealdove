package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.dto.OrderDetailDTO;
import com.dealdove.dealdove.model.dto.ShoppingCartDTO;
import com.dealdove.dealdove.service.OrderDetailService;
import com.dealdove.dealdove.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {
    private OrderService orderService;
    private OrderDetailService orderDetailService;

    public OrderController(OrderService orderService, OrderDetailService orderDetailService) {
        this.orderService = orderService;
        this.orderDetailService = orderDetailService;
    }

    @PostMapping("/showOrderName")
    public List<HashMap<String,String>> getOrderItemsByOrderID(@RequestBody LinkedHashMap<String, String> user) {
        return orderService.getOrderItemsNameByOrderID(user);
    }
    @PostMapping("/showOrderStatus")
    public List<HashMap<String,String>> showOrderStatus(@RequestBody LinkedHashMap<String, String> user){
        return orderService.findAllOrder(user);
    }

    @CrossOrigin(origins = "*",maxAge = 3600)
    @PostMapping("/ecpayCheckout")
    public String ecpayCheckout() {
        String aioCheckOutALLForm = orderService.ecpayCheckout();
        return  aioCheckOutALLForm;
    }

//    遊戲直接結束
    @PostMapping("/ecpayMapChoosing")
    public String ecpayMapChoosing() {
        String map = orderService.ecpayMap("Dylan", "0978095607");
        return map;
    }

    @GetMapping("/orderConfirmation")
    public String orderConfirmation() {
        return "orderConfirmation";
    }

    @PostMapping("/getOrderBySellerID")
    public Map<String, List<OrderDetailDTO>> getOrderBySellerID(@RequestBody LinkedHashMap<String, String> user){
        return orderDetailService.findOrderBySellerID(user);
    }

    @PostMapping("/showOrders")
    public List<HashMap<String,String>> showOrderInfo(@RequestBody LinkedHashMap<String, String> user){
        return orderService.showOrderPage(user);
    }

}

