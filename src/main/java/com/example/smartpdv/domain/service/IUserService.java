package com.example.smartpdv.domain.service;

import com.example.smartpdv.application.request.UserRequest;
import com.example.smartpdv.application.response.UserResponse;
import com.example.smartpdv.domain.model.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {

    List<Usuario> listUsers();

    UserResponse getUser(Long userId);

    UserResponse updateUser(Long idUser, UserRequest userRequest);

    void deleteUser(Long userId);

}
