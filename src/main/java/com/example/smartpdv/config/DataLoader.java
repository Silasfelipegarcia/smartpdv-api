package com.example.smartpdv.config;

import com.example.smartpdv.domain.model.Usuario;
import com.example.smartpdv.infra.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner initAdmin(UserRepository repo, PasswordEncoder encoder) {
        return args -> {
            if (repo.findByUsername("admin").isEmpty()) {
                Usuario admin = new Usuario();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("123456"));
                admin.setRole("ADMIN");
                repo.save(admin);

                System.out.println("Usuário ADMIN criado com sucesso!");
            }
        };
    }

}
