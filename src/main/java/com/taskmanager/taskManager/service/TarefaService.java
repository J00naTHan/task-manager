package com.taskmanager.taskManager.service;

import com.taskmanager.taskManager.entity.Tarefa;
import com.taskmanager.taskManager.entity.User;
import com.taskmanager.taskManager.repository.TarefaRepository;
import com.taskmanager.taskManager.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final UserRepository userRepository;

    public TarefaService(TarefaRepository tarefaRepository, UserRepository userRepository) {
        this.tarefaRepository = tarefaRepository;
        this.userRepository = userRepository;
    }

    // Criar nova tarefa
    public Tarefa criarTarefa(Long userId, Tarefa tarefa) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }

        User user = userOptional.get();
        tarefa.setAutor(user);
        tarefa.setCreatedAt(LocalDateTime.now());
        tarefa.setExpired(false);
        return tarefaRepository.save(tarefa);
    }

    // Buscar todas as tarefas
    public List<Tarefa> buscarTodasTarefas() {
        return tarefaRepository.findAll();
    }

    // Buscar tarefa por ID
    public Optional<Tarefa> buscarPorId(Long id) {
        return tarefaRepository.findById(id);
    }

    // Atualizar tarefa
    public Tarefa atualizarTarefa(Long id, Tarefa novaTarefa) {
        Tarefa tarefaExistente = tarefaRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Tarefa não encontrada.")
        );

        tarefaExistente.setName(novaTarefa.getName());
        tarefaExistente.setDescription(novaTarefa.getDescription());
        tarefaExistente.setPriority(novaTarefa.getPriority());
        tarefaExistente.setTag(novaTarefa.getTag());
        tarefaExistente.setStatus(novaTarefa.getStatus());
        tarefaExistente.setDeadline(novaTarefa.getDeadline());
        tarefaExistente.setUpdatedAt(LocalDateTime.now());

        return tarefaRepository.save(tarefaExistente);
    }

    // Deletar tarefa
    public void deletarTarefa(Long id) {
        if (!tarefaRepository.existsById(id)) {
            throw new IllegalArgumentException("Tarefa não encontrada.");
        }
        tarefaRepository.deleteById(id);
    }
}


