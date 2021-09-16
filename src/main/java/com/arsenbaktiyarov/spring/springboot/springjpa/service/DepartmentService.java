package com.arsenbaktiyarov.spring.springboot.springjpa.service;

import com.arsenbaktiyarov.spring.springboot.springjpa.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();

    Department findById(Long id);

    Department findByName(String name);

    Department save(Department department);

    void delete(Department department);

    void deleteById(Long id);

}
