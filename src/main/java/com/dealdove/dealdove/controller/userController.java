package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.Message;
import com.dealdove.dealdove.model.User;
import com.dealdove.dealdove.service.MessageService;
import com.dealdove.dealdove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;

@RestController
public class userController {

    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;



    //    test123456
    @GetMapping("/04_product_page")
    public String productPage(Model model){
        return "04_product_page";
    }

    @RequestMapping("/link")
    public List<User> test2(){
        //回傳userService查詢到的資料
        System.out.println(userService.findAllUsers()+"123456789");
        System.out.println("123456789");
        return userService.findAllUsers();
    }
    @RequestMapping("/time")
    public List<Message> test3(){
        Message message = messageService.getMessageByID(2);
        System.out.println(messageService.getAllMessage()+"123");
        System.out.println(message.getMessageID());
        messageService.saveMessage(1,2,"Saved123");
        return messageService.findMessage();
    }


}
