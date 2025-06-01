package com.example.smartpdv.infra.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordHashGeneratorUtil {

    public static String geraHash(String password) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "123456"; // aqui você coloca a senha que quiser criptografar
        String encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println("Senha criptografada: " + encodedPassword);
        return rawPassword;
    }

}
