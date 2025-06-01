package com.example.smartpdv.api.controller;


import com.example.smartpdv.application.request.LoginRequest;
import com.example.smartpdv.application.response.TokenResponse;
import com.example.smartpdv.config.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
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
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest loginRequest){


        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));

        User user = (User) authenticate.getPrincipal();
        String userName = user.getUsername();

        List<String> roles = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .map(role -> role.replace("ROLE_", "")) // remove prefixo ROLE_
                .collect(Collectors.toList());

        // Gera token
        String token = jwtTokenProvider.generateToken(userName, roles);

        // Retorna token para o client
        return new TokenResponse(token);
    }

}
