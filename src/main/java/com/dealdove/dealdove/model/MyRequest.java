package com.dealdove.dealdove.model;


import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRequest {
    private String name;
    private String email;

    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}


