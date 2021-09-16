package com.arsenbaktiyarov.spring.employees.service;

import com.arsenbaktiyarov.spring.employees.entity.Department;
import com.arsenbaktiyarov.spring.employees.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @Override
    public List<Department> findAll() {
        return (List<Department>) departmentRepository.findAll();
    }

    @Override
    public Department findById(Long id) {
        Optional<Department> departmentById = departmentRepository.findById(id);
        if (departmentById.isPresent()) {
            return departmentById.get();
        } else {
            throw new RuntimeException("Department not found...");
        }
    }

    @Override
    public Department findByName(String name) {
        return departmentRepository.findByName(name);
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void delete(Department department) {
        departmentRepository.delete(department);
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }
}
