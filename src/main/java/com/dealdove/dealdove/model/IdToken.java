package com.dealdove.dealdove.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IdToken {
    @JsonProperty("idToken")
    private String idToken;

    public IdToken() {
    }

    public IdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getIdToken() {
        return idToken;
    }
}
