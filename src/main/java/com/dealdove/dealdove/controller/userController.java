package com.dealdove.dealdove.controller;

import com.amazonaws.services.dynamodbv2.xspec.M;
import com.dealdove.dealdove.model.*;
import com.dealdove.dealdove.service.MessageService;
import com.dealdove.dealdove.service.UserService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

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
        return userService.findAllUsers();
    }
    @RequestMapping("/time")
    public List<Message> test3(){
        Message message = messageService.getMessageByID(3,1);
        System.out.println(messageService.getAllMessage()+"123");
        System.out.println(message.getText());
        messageService.saveMessage(1,2,"Saveddefault");
        return messageService.findMessage();
    }

    @PostMapping("Users")
    public String user(@RequestBody IdToken idToken){
        System.out.println(idToken.getIdToken());
        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken.getIdToken());
            String email = decodedToken.getEmail();
            String uid = decodedToken.getUid();
            String name = (decodedToken.getName()==null)? decodedToken.getEmail(): decodedToken.getName();
            System.out.println("breakpoint");
            System.out.println(email);
            System.out.println(uid);
            System.out.println(name);
            userService.save(uid,name,email,true);
            return idToken.getIdToken();
        } catch (FirebaseAuthException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/Member")
    public @ResponseBody String member(@RequestBody IdToken idToken){
          try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken.getIdToken());
            String uid = decodedToken.getUid();
            String email = userService.findUserById(uid);
            return "{\"email\":\""+email+"\"}";
        } catch (FirebaseAuthException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }



//    public FirebaseToken getFirebaseToken(IdToken idToken){
//        try {
//            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken.getIdToken());
//            String uid = decodedToken.getUid();
//            String email = userS ervice.findUserById(uid);
//            return decodedToken;
//        } catch (FirebaseAuthException e) {
//            System.out.println(e);
//            throw new RuntimeException(e);
//        }
//    }



}
