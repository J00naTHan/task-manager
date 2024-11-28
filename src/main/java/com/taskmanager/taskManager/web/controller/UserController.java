package com.taskmanager.taskManager.web.controller;

import com.taskmanager.taskManager.entity.User;
import com.taskmanager.taskManager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/usuarios")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userEntrada) {
        User user = userService.save(userEntrada);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
