package com.example.smartpdv.application.service;

import com.example.smartpdv.domain.model.Usuario;
import com.example.smartpdv.domain.service.IAuthService;
import com.example.smartpdv.infra.repository.UserRepository;
import com.example.smartpdv.infra.utils.PasswordHashGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class AuthServiceImpl implements IAuthService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public Optional<Usuario> registerUser(Usuario usuario) {
        String passwordHash = PasswordHashGeneratorUtil.geraHash(usuario.getPassword());
        usuario.setPassword(passwordHash);

        Usuario save = userRepository.save(usuario);
        return Optional.of(save);
    }

}
