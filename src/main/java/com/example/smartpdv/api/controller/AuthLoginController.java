package com.example.smartpdv.api.controller;


import com.example.smartpdv.application.request.LoginRequest;
import com.example.smartpdv.application.request.AuthRequest;
import com.example.smartpdv.application.response.TokenResponse;
import com.example.smartpdv.domain.service.IAuthencationService;
import com.example.smartpdv.domain.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthLoginController {
    

    @Autowired
    private IAuthService userService;

    @Autowired
    private IAuthencationService authencationService;

    @PostMapping("login")
    public TokenResponse login(@RequestBody LoginRequest loginRequest){
        String token = authencationService.generateToken(loginRequest);
        return new TokenResponse(token);
    }


    @PostMapping("register")
    public ResponseEntity register(@RequestBody AuthRequest authRequest){
        userService.registerUser(authRequest.converter());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
