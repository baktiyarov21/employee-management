package com.arsenbaktiyarov.spring.employees.service;

import com.arsenbaktiyarov.spring.employees.entity.Task;
import com.arsenbaktiyarov.spring.employees.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return (List<Task>) taskRepository.findAll();
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task findById(Long id) {
        Optional<Task> taskFromBD = taskRepository.findById(id);
        Task task = null;
        if (taskFromBD.isPresent()) {
            task = taskFromBD.get();
        }
        return task;

    }

    @Override
    public void delete(Task task) {
        taskRepository.delete(task);

    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
