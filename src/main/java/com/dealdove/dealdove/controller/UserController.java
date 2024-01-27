package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.User;
import com.dealdove.dealdove.service.MessageService;
import com.dealdove.dealdove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
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
    public @ResponseBody String showInfo(@RequestBody  LinkedHashMap<String, String> user) {
      Object[] userInfo =  userService.showInfo(user);
        return "{\"email\":\"" + userInfo[0] + "\",\"gender\":\""+userInfo[1]+"\",\"birthday\":\""+userInfo[2]+
                "\",\"picture\":\""+userInfo[3]+"\"}";
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

