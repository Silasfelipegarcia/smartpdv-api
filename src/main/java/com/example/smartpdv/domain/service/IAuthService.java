package com.example.smartpdv.domain.service;

import com.example.smartpdv.domain.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IAuthService {

    Optional<Usuario> registerUser(Usuario usuario);

}
