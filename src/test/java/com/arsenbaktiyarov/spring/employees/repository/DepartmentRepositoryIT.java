package com.arsenbaktiyarov.spring.employees.repository;

import com.arsenbaktiyarov.spring.employees.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class DepartmentRepositoryIT {
    @Autowired
    DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByName() {
      Department department = departmentRepository.findByName("IT");
      assertEquals("IT", department.getName());
    }
}