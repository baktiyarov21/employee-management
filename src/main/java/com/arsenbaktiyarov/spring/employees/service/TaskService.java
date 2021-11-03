package com.arsenbaktiyarov.spring.employees.service;


import com.arsenbaktiyarov.spring.employees.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();

    Task save(Task task);

    Task findById(Long id);

    void delete(Task task);

    void deleteById(Long id);
}
