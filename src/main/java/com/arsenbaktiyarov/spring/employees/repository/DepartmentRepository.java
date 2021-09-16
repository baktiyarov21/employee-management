package com.arsenbaktiyarov.spring.employees.repository;

import com.arsenbaktiyarov.spring.employees.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
    Department findByName(String name);
}
