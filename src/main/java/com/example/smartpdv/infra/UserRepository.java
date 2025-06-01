package com.example.smartpdv.infra;


import com.example.smartpdv.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);

}
