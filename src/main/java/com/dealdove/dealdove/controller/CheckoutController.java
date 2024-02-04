package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.dao.OrderRepository;
import com.dealdove.dealdove.model.dto.OrderDto;
import com.dealdove.dealdove.model.dto.TokenDto;
import com.dealdove.dealdove.model.enitity.Order;
import com.dealdove.dealdove.model.enitity.Product;
import com.dealdove.dealdove.model.enitity.ShoppingCartItem;
import com.dealdove.dealdove.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/09_checkoutPage")
public class CheckoutController {

    private final CheckoutService checkoutService;
    private final OrderRepository orderRepository; // 添加对 OrderRepository 的引用


    @Autowired
    public CheckoutController(CheckoutService checkoutService, OrderRepository orderRepository) {
        this.checkoutService = checkoutService;
        this.orderRepository = orderRepository; // 初始化 orderRepository
    }
    @PostMapping("/submitOrder")
    public ResponseEntity<?> submitOrder(@RequestBody OrderDto orderDto) {
        // 從OrderDto來取得前端回傳資料
        String buyerComment = orderDto.getBuyerComment();
        String shippingAddress = orderDto.getShippingAddress();
        Integer totalPrice = orderDto.getTotalPrice();
        Order order = new Order();
        order.setBuyerComment(buyerComment);
        order.setShippingAddress(shippingAddress);
        order.setTotalPrice(totalPrice);

        Order savedOrder = orderRepository.save(order);
        // 創建響應
        Map<String, Object> response = new HashMap<>();
        response.put("orderId", savedOrder.getOrderID());
        return ResponseEntity.ok(response);
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

//    @GetMapping("/shoppingCart/{userID}/modelInfo")
//    public ResponseEntity<?> getShoppingCartModelAndQuantity(@PathVariable String userID) {
//        // 找商品規格
//        String models = checkoutService.getModelsForUser(userID);
//        // 找下單數量
//        Integer quantity = checkoutService.getQuantityForUser(userID);
//
//        // 检查規格和下單量是否存在
//        if(models != null && quantity != null) {
//            // 如果两者都存在，将它们一起返回
//            Map<String, Object> response = new HashMap<>();
//            response.put("models", models);
//            response.put("quantity", quantity);
//            return ResponseEntity.ok().body(response);
//        } else {
//            // 如果任一不存在，返回404 Not Found
//            return ResponseEntity.notFound().build();
//        }
//    }
}