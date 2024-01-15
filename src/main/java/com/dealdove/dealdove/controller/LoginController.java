package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.Account;
import com.dealdove.dealdove.model.IdToken;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.web.bind.annotation.*;


@RestController
public class LoginController {

    @PostMapping( "/login3")
    public @ResponseBody String login(@RequestBody IdToken idToken){
        System.out.println(idToken.getIdToken());
        System.out.println("breakpoint");


        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken.getIdToken());
            String email = decodedToken.getEmail();
            String uid = decodedToken.getUid();
            String name = decodedToken.getName();
            System.out.println("breakpoint");
            System.out.println(email);
            System.out.println(uid);
            System.out.println(name);
            return idToken.getIdToken();
        } catch (FirebaseAuthException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }


}
