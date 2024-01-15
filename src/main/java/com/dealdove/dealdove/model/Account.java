package com.dealdove.dealdove.model;

public class Account {
    private String email;
    private String password;

    private String displayName;

    private String uid;
    public Account() {
    }

    public Account(String email, String password, String displayName,String uid) {
        this.email = email;
        this.password = password;
        this.displayName = displayName;
        this.uid=uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
