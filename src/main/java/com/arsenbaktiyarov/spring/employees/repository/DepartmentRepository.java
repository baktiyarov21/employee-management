package com.arsenbaktiyarov.spring.employees.repository;

import com.arsenbaktiyarov.spring.employees.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByName(String name);
}
