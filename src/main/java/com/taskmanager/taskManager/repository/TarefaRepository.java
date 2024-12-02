package com.taskmanager.taskManager.repository;
import com.taskmanager.taskManager.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByAutor_Email(String email);
    List<Tarefa> findByStatus(String status);
}
