package com.dealdove.dealdove.service;

import com.dealdove.dealdove.dao.OrderRepository;
import com.dealdove.dealdove.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAllOrders(){
        return orderRepository.findAllOrders();
    }
}
