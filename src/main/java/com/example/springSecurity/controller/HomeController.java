package com.example.springSecurity.controller;

import com.example.springSecurity.dto.AuthenticationRequest;
import com.example.springSecurity.dto.AuthenticationResponse;
import com.example.springSecurity.securityconfig.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    JWTUtil jwtTokenUtil;

    //Endpoint for login.

    @PostMapping("/authenticate")
    public AuthenticationResponse authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserEmailId()
            ,authenticationRequest.getPassword()));
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password",e);
        }

        final UserDetails userDetails=userDetailsService.loadUserByUsername(authenticationRequest.getUserEmailId());
        final String jwt= jwtTokenUtil.generateToken(userDetails);

        return new AuthenticationResponse(jwt);


    }

    @GetMapping("/welcome/admin")
    public String welcomeAdmin() {
        return "Welcome Admin";
    }

    @GetMapping("/welcome/trainer")
    public String welcomeTrainer(){

        return "welcome Trainer";
    }
}
