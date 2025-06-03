package com.example.smartpdv.api.controller;


import com.example.smartpdv.application.request.UserRequest;
import com.example.smartpdv.application.response.UserResponse;
import com.example.smartpdv.domain.model.Usuario;
import com.example.smartpdv.domain.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;


    @GetMapping
    public List<Usuario> listUsers(){
        return userService.listUsers();
    }


    @GetMapping("/{id_usuario}")
    public UserResponse getUser(@PathVariable Long id_usuario){
        return userService.getUser(id_usuario);
    }


    @PutMapping("/{id_usuario}")
    public UserResponse updateUser(@PathVariable Long id_usuario, @RequestBody UserRequest userRequest){
        return userService.updateUser(id_usuario, userRequest);
    }

    @DeleteMapping("/{id_usuario}")
    public ResponseEntity deleteUser(@PathVariable Long id_usuario) {
        userService.deleteUser(id_usuario);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
