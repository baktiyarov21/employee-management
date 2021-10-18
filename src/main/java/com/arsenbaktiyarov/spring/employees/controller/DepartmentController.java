package com.arsenbaktiyarov.spring.employees.controller;

import com.arsenbaktiyarov.spring.employees.entity.Department;

import java.util.List;

public interface DepartmentController {
    List<Department> findAll();

    Department findById(Long id);

    Department findByName(String name);

    Department save(Department department);

    String delete(Department department);

    String deleteById(Long id);
}
