package com.arsenbaktiyarov.spring.employees.service;

import com.arsenbaktiyarov.spring.employees.entity.Department;
import com.arsenbaktiyarov.spring.employees.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @Override
    @Transactional
    public List<Department> findAll() {
        return (List<Department>) departmentRepository.findAll();
    }

    @Override
    @Transactional
    public Department findById(Long id) {
        Optional<Department> departmentById = departmentRepository.findById(id);
        if (departmentById.isPresent()) {
            return departmentById.get();
        } else {
            throw new RuntimeException("Department not found...");
        }
    }

    @Override
    @Transactional
    public Department findByName(String name) {
        return departmentRepository.findByName(name);
    }

    @Override
    @Transactional
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    @Transactional
    public void delete(Department department) {
        departmentRepository.delete(department);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }
}
