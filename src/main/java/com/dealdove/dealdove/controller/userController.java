package com.dealdove.dealdove.controller;

import com.amazonaws.services.dynamodbv2.xspec.M;
import com.dealdove.dealdove.model.*;
import com.dealdove.dealdove.service.MessageService;
import com.dealdove.dealdove.service.UserService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class userController {

    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;

    //    取得FirebaseToken method
    public FirebaseToken getFirebaseToken(IdToken idToken) {
        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken.getIdToken());
            return decodedToken;
        } catch (FirebaseAuthException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/link")
    public List<User> test2() {
        //回傳userService查詢到的資料
        return userService.findAllUsers();
    }

    @RequestMapping("/time")
    public List<Message> test3() {
        Message message = messageService.getMessageByID(3, 1);
        System.out.println(messageService.getAllMessage() + "123");
        System.out.println(message.getText());
        messageService.saveMessage(1, 2, "Saveddefault");
        return messageService.findMessage();
    }

    @PostMapping("Users")
    public String user(@RequestBody IdToken idToken) {
        System.out.println(idToken.getIdToken());
        FirebaseToken decodedToken = getFirebaseToken(idToken);
        String email = decodedToken.getEmail();
        String uid = decodedToken.getUid();
        String name = (decodedToken.getName() == null) ? decodedToken.getEmail() : decodedToken.getName();
        userService.save(uid, name, email, true);
        return idToken.getIdToken();

    }

    @PostMapping("/memberEmail")
    public @ResponseBody String member(@RequestBody IdToken idToken) {
        FirebaseToken decodedToken = getFirebaseToken(idToken);
        String uid = decodedToken.getUid();
        String email = userService.findUserById(uid);
        return "{\"email\":\"" + email + "\"}";
    }

    @PostMapping("/gender")
    public @ResponseBody int gender(@RequestBody LinkedHashMap<String, String> gender){
//        JSONObject usergender =  (JSONObject) gender;
        Integer usergender = Integer.parseInt(gender.get("gender"));
        System.out.println(usergender);
        userService.update(usergender,"IfTWAVV2ItNzRa0gTJyXIQzVuCw1");
        return usergender;
    }


}

