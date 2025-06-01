package com.example.smartpdv.application.response;

public class TokenResponse {


    public TokenResponse(){}

    public TokenResponse(String token) {
        this.token = token;
    }

    private String token;

    public String getToken() {
        return token;
    }
}
