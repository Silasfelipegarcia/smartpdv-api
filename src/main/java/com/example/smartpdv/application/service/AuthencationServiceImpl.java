package com.example.smartpdv.application.service;

import com.example.smartpdv.application.request.LoginRequest;
import com.example.smartpdv.application.response.TokenResponse;
import com.example.smartpdv.config.JwtTokenProvider;
import com.example.smartpdv.domain.service.IAuthencationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class AuthencationServiceImpl implements IAuthencationService {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public String generateToken(LoginRequest loginRequest) {

        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        User user = (User) authenticate.getPrincipal();
        String userName = user.getUsername();

        List<String> roles = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .map(role -> role.replace("ROLE_", "")) // remove prefixo ROLE_
                .collect(Collectors.toList());

        // Gera token
        return jwtTokenProvider.generateToken(userName, roles);
    }

}
