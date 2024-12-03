package com.taskmanager.taskManager.DTO;

public class LoginRequest {
    private String email;
    private String password;

    // Construtor vazio (necessário para frameworks como Jackson)
    public LoginRequest() {
    }

    // Construtor com argumentos
    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getter para email
    public String getEmail() {
        return email;
    }

    // Setter para email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter para password
    public String getPassword() {
        return password;
    }

    // Setter para password
    public void setPassword(String password) {
        this.password = password;
    }
}
