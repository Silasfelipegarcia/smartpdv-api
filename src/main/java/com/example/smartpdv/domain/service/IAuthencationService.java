package com.example.smartpdv.domain.service;


import com.example.smartpdv.application.request.LoginRequest;

public interface IAuthencationService {

    String generateToken(LoginRequest loginRequest);

}
