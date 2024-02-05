package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.dao.OrderRepository;
import com.dealdove.dealdove.model.dto.OrderDto;
import com.dealdove.dealdove.model.dto.TokenDto;
import com.dealdove.dealdove.model.enitity.*;
import com.dealdove.dealdove.service.CheckoutService;
import com.dealdove.dealdove.service.CouponService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/09_checkoutPage")
public class CheckoutController {

    private final CheckoutService checkoutService;
    private final CouponService couponService;
    private final OrderRepository orderRepository; // 添加对 OrderRepository 的引用


    @Autowired
    public CheckoutController(CheckoutService checkoutService, OrderRepository orderRepository,CouponService couponService) {
        this.checkoutService = checkoutService;
        this.orderRepository = orderRepository;
        this.couponService = couponService;
    }
    @PostMapping("/submitOrder")
    public ResponseEntity<?> submitOrder(@RequestBody OrderDto orderDto) {
        try {
            Order order = new Order();
            order.setBuyerComment(orderDto.getBuyerComment());
            order.setShippingAddress(orderDto.getShippingAddress());
            order.setTotalPrice(orderDto.getTotalPrice());
            order.setPaymentID(orderDto.getPaymentID());
            order.setOrderStatus(orderDto.getOrderStatus());
            order.setBuyerID(orderDto.getBuyerID());

            order.setOrderDate(ZonedDateTime.now(ZoneId.of("Asia/Taipei")));

            Order savedOrder = orderRepository.save(order);

            Map<String, Object> response = new HashMap<>();
            response.put("orderId", savedOrder.getOrderID());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Order submission failed");
        }
    }

    //拿
    @GetMapping("/checkoutDetail/{userID}")
    public void getCheckoutDetailByUserID(@PathVariable String userID) {
        System.out.println("User ID: " + userID);
        List<Object[]> checkoutDetail = checkoutService.findCheckoutDetailByUserID(userID);
        for (Object[] objects : checkoutDetail) {
            System.out.println("Product ID: " + objects[0]);
            System.out.println("Product Name: " + objects[1]);
            System.out.println("Product Price: " + objects[2]);
            System.out.println("Product Quantity: " + objects[3]);
            System.out.println("Product Model: " + objects[4]);
        }
    }

    @GetMapping("/{productID}/images")
    public ResponseEntity<List<String>> getProductImages(@PathVariable Integer productID) {
        List<String> images = checkoutService.getProductImages(productID);
        if (images.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(images);
        }
    }
    @GetMapping("/product/details/{productID}")
    public ResponseEntity<String> getProductDetails(@PathVariable int productID) {
        String productName = checkoutService.getProductName(productID);
        if (productName != null && !productName.isEmpty()) {
            return ResponseEntity.ok(productName);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/shoppingCart/cartItems")
    public ResponseEntity<?> getCartItems(@RequestBody TokenDto tokenDto) {
        try {
            List<ShoppingCartItem> cartItems = checkoutService.getCartItemsByToken(tokenDto.getToken());
            return ResponseEntity.ok(cartItems);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

//    優惠券

    @PostMapping("/userCoupons")
    public ResponseEntity<?> getUserCoupons(@RequestBody TokenDto tokenDto) {
        try {
            String userID = checkoutService.getUserIdFromToken(tokenDto.getToken());
            List<Coupon> userCoupons = checkoutService.getUserCoupons(userID);
            // 如果需要进一步处理优惠券数据，可以在这里进行
            return ResponseEntity.ok(userCoupons);
        } catch (FirebaseAuthException e) {
            // 认证异常的处理
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        } catch (Exception e) {
            // 其他异常的处理
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error getting coupons");
        }
    }

    // 获取优惠券基础信息
    @GetMapping("/couponBaseDetails/{couponBaseID}")
    public ResponseEntity<?> getCouponBaseDetails(@PathVariable Integer couponBaseID) {
        try {
            CouponBase couponBaseDetails = checkoutService.getCouponBaseDetails(couponBaseID);
            if (couponBaseDetails != null) {
                // 如果需要对返回的数据结构进行调整，可以在这里进行
                return ResponseEntity.ok(couponBaseDetails);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error getting coupon details");
        }
    }




}