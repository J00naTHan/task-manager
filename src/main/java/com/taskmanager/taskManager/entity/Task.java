package com.taskmanager.taskManager.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tasks")
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
}
