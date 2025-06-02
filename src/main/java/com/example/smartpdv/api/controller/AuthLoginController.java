package com.example.smartpdv.api.controller;


import com.example.smartpdv.application.request.LoginRequest;
import com.example.smartpdv.application.request.UserRequest;
import com.example.smartpdv.application.response.TokenResponse;
import com.example.smartpdv.config.JwtTokenProvider;
import com.example.smartpdv.domain.model.Usuario;
import com.example.smartpdv.domain.service.IAuthencationService;
import com.example.smartpdv.domain.service.IUserService;
import com.example.smartpdv.infra.repository.UserRepository;
import org.hibernate.internal.util.collections.ArrayHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.userdetails.User;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("auth")
public class AuthLoginController {






    @Autowired
    private IUserService userService;

    @Autowired
    private IAuthencationService authencationService;

    @PostMapping("login")
    public TokenResponse login(@RequestBody LoginRequest loginRequest){
        String token = authencationService.generateToken(loginRequest);
        return new TokenResponse(token);
    }


    @PostMapping("register")
    public ResponseEntity register(@RequestBody UserRequest userRequest){
        userService.registerUser(userRequest.converter());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
