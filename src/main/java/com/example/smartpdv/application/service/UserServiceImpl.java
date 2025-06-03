package com.example.smartpdv.application.service;

import com.example.smartpdv.application.request.UserRequest;
import com.example.smartpdv.application.response.UserResponse;
import com.example.smartpdv.domain.model.Usuario;
import com.example.smartpdv.domain.service.IUserService;
import com.example.smartpdv.infra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
class UserServiceImpl implements IUserService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public List<Usuario> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserResponse getUser(Long userId) {
        Optional<Usuario> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        Usuario usuario = optionalUser.get();
        return new UserResponse(usuario);
    }


    @Override
    public UserResponse updateUser(Long userId, UserRequest userRequest) {
        Optional<Usuario> usuarioOptional = userRepository.findById(userId);
        if(usuarioOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Usuario usuario = usuarioOptional.get();
        usuario.setUsername(userRequest.getUsername());
        usuario.setRole(userRequest.getRole());

        return new UserResponse(userRepository.save(usuario));
    }

    @Override
    public void deleteUser(Long userId) {
        Optional<Usuario> user = userRepository.findById(userId);
        if(user.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        userRepository.delete(user.get());
    }

}
