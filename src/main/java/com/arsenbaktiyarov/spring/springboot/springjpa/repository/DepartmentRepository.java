package com.arsenbaktiyarov.spring.springboot.springjpa.repository;

import com.arsenbaktiyarov.spring.springboot.springjpa.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
    Department findByName(String name);
}
