package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.Account;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.web.bind.annotation.*;


@RestController
public class LoginController {

    @PostMapping( "/login3")
    public  String login(@RequestBody LoginForm idToken){
        System.out.println(idToken);
        System.out.println(idToken.);
        FirebaseToken decodedToken;
        try {
            decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken.get);
        } catch (FirebaseAuthException e) {
            throw new RuntimeException(e);
        }
        System.out.println("breakpoint");
        String email = decodedToken.getEmail();
        String uid = decodedToken.getUid();
        String name = decodedToken.getName();
        System.out.println(email);
        System.out.println(uid);
        System.out.println(name);
        return idToken;
    }

    public class LoginForm{
        static String idToken;

        public LoginForm() {
        }

        public static String getIdToken() {
            return idToken;
        }

        public static void setIdToken(String idToken) {
            LoginForm.idToken = idToken;
        }
    }
}
