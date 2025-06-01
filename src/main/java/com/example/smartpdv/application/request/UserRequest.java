package com.example.smartpdv.application.request;

import com.example.smartpdv.domain.model.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class UserRequest {


    private String username;

    private String password;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Usuario converter(){
        Usuario usuario = new Usuario();
        usuario.setPassword(this.password);
        usuario.setUsername(this.username);
        usuario.setRole("ADMIN");
        return usuario;
    }



}
