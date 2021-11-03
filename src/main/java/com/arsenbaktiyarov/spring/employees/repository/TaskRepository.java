package com.arsenbaktiyarov.spring.employees.repository;

import com.arsenbaktiyarov.spring.employees.entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
