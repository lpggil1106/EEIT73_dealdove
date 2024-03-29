package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.enitity.User;
import com.dealdove.dealdove.service.MessageService;
import com.dealdove.dealdove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;



@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;

    @PostMapping("/Users")
    public String user(@RequestBody  LinkedHashMap<String, String> user) {
      userService.login(user);
        return "";

    }
//    設定使用者資訊
    @PostMapping("/setInfo")
    public @ResponseBody int updateUser(@RequestBody LinkedHashMap<String, String> user){
        userService.updateUser(user);
        return 1;
    }


//    顯示使用者資訊
    @PostMapping("/showInfo")
    public @ResponseBody  List<HashMap<String,String>> member(@RequestBody  LinkedHashMap<String, String> user) {

        return userService.showInfo(user);
    }

    @PostMapping("/showCoupon")
    public List<String> showCoupon(@RequestBody  LinkedHashMap<String, String> user){
         return userService.showCoupon(user);
    }




    @MessageMapping("/user.addUser")
    @SendTo("/user/public")
    public User addUser(
            @Payload User user
    ) {
        userService.saveUser(user);
        return user;
    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/public")
    public User disconnectUser(
            @Payload User user
    ) {
        userService.disconnect(user);
        return user;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findConnectedUsers() {
        return ResponseEntity.ok(userService.findConnectedUsers());
    }
}

