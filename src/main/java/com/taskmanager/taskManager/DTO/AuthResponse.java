package com.taskmanager.taskManager.DTO;

public class AuthResponse {
    private String token;

    // Construtor vazio (necessário para frameworks como Jackson)
    public AuthResponse() {
    }

    // Construtor com argumentos
    public AuthResponse(String token) {
        this.token = token;
    }

    // Getter para token
    public String getToken() {
        return token;
    }

    // Setter para token
    public void setToken(String token) {
        this.token = token;
    }
}

