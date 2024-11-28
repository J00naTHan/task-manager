package com.taskmanager.taskManager.service;

import com.taskmanager.taskManager.entity.User;
import com.taskmanager.taskManager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User save(User userEntrada) {
        return userRepository.save(userEntrada);
    }
}
