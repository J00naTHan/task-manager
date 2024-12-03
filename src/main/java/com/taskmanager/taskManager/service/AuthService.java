package com.taskmanager.taskManager.service;

import com.taskmanager.taskManager.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticate(String email, String password) {
        // Validação fictícia (substitua por lógica real)
        if ("user@example.com".equals(email) && "password".equals(password)) {
            return jwtUtil.generateToken(email);
        }
        throw new RuntimeException("Credenciais inválidas");
    }
}

