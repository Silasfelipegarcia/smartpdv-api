package com.example.smartpdv.application.response;

import com.example.smartpdv.domain.model.Usuario;
import jakarta.persistence.Column;

public class UserResponse {

    public UserResponse(Usuario usuario) {
        this.username = usuario.getUsername();
        this.role = usuario.getRole();
    }


    private String username;

    private String role;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
