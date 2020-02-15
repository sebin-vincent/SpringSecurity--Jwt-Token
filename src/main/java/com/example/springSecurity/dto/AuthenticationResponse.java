package com.example.springSecurity.dto;

//Model for Login response
public class AuthenticationResponse {


    public AuthenticationResponse(String jwt) {

        this.jwt = jwt;
    }

    private final String jwt;



    public String getJwt() {
        return jwt;
    }
}
