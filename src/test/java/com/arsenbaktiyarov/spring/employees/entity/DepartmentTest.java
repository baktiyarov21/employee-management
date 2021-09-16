package com.arsenbaktiyarov.spring.employees.entity;




import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    Department department;

    @BeforeEach
    void setUp() {
        department = new Department();
    }

    @Test
    void getId() {
        Long id = 4L;
        department.setId(id);
        assertEquals(id, department.getId());
    }

    @Test
    void getName() {

    }

    @Test
    void getEmployees() {
    }
}