package com.taskmanager.taskManager.repository;

import com.taskmanager.taskManager.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
