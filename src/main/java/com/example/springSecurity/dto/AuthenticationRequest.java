package com.example.springSecurity.dto;


//Model for LoginRequest
public class AuthenticationRequest {

    private String userEmailId;
    private String password;

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String userEmailId, String password) {
        this.userEmailId = userEmailId;
        this.password = password;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
